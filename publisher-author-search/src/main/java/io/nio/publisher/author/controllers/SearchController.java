package io.nio.publisher.author.controllers;

import io.nio.publisher.author.entity.Author;
import io.nio.publisher.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class SearchController {

    private AuthorRepository authorRepository;

    @Autowired
    public void AuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository=authorRepository;
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<List<Author>> addAuthor(@PathVariable long isbn){
        List<Author> authorList = authorRepository.findAllByISBN(isbn);
        if(authorList.isEmpty())
            return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);

        return  new ResponseEntity<List<Author>>(authorList,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Author>> addAuthor(){
        List<Author> authorList = authorRepository.findAll();
        if(authorList.isEmpty())
            return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);

        return  new ResponseEntity<List<Author>>(authorList,HttpStatus.OK);
    }
}
