package io.nio.publisher.book.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.nio.publisher.author.entity.Author;
import io.nio.publisher.author.proxy.AuthorSearchProxy;
import io.nio.publisher.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/book")
@EnableFeignClients(basePackages = "io.nio.publisher")
public class BookController {
    @Autowired
    RestTemplate httpClient;

    @Autowired
    AuthorSearchProxy authorSearchProxy;

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> findAuthorsOfBook(@PathVariable long isbn){
        ResponseEntity<Book> bookResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> listResponseEntity = httpClient.getForEntity("http://PUBLISHER-AUTHOR-SEARCH/author/search/isbn/{isbn}",List.class,isbn);

        Book book = new Book(isbn,"dummy name","dummy-publisher",listResponseEntity.getBody());
        bookResponseEntity = new ResponseEntity<>(book,HttpStatus.OK);
        return bookResponseEntity;
    }


    @GetMapping("/isbn/v2/{isbn}")
    @CircuitBreaker(name = "isbn",fallbackMethod = "findAuthorsOfBook_fallback")
    public ResponseEntity<Book> findAuthorsOfBook_v2(@PathVariable long isbn){
        ResponseEntity<Book> bookResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ResponseEntity<List<Author>> listResponseEntity = authorSearchProxy.findAllAuthorsByISBN(isbn);

        Book book = new Book(isbn,"dummy name","dummy-publisher",listResponseEntity.getBody());
        bookResponseEntity = new ResponseEntity<>(book,HttpStatus.OK);
        return bookResponseEntity;
    }

    public ResponseEntity<Book> findAuthorsOfBook_fallback(@PathVariable long isbn,Throwable t){
        ResponseEntity<Book> bookResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Book book = new Book(isbn,"norecord","norecord",null);
        bookResponseEntity = new ResponseEntity<>(book,HttpStatus.OK);
        return bookResponseEntity;
    }

}
