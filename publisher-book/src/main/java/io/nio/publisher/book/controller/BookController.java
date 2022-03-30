package io.nio.publisher.book.controller;

import io.nio.publisher.author.entity.Author;
import io.nio.publisher.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    RestTemplate httpClient;

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> findAuthorsOfBook(@PathVariable long isbn){
        ResponseEntity<Book> bookResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> listResponseEntity = httpClient.getForEntity("http://PUBLISHER-AUTHOR-SEARCH/author/isbn/{isbn}",List.class,isbn);

        Book book = new Book(isbn,"dummy name","dummy-publisher",listResponseEntity.getBody());
        bookResponseEntity = new ResponseEntity<>(book,HttpStatus.OK);
        return bookResponseEntity;
    }
}
