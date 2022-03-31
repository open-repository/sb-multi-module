package io.nio.author.controllers;

import io.nio.author.entity.Author;
import io.nio.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author/search")
public class SearchController {


    private AuthorRepository authorRepository;

    @Autowired
    public void AuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository=authorRepository;
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<List<Author>> findByISBN(@PathVariable long isbn){

        System.out.println("Searching for isbn .... "+isbn);
        List<Author> authorList = authorRepository.findAllByISBN(isbn);
        if(authorList.isEmpty())
            return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);

        return  new ResponseEntity<List<Author>>(authorList,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Author>> findAll(){
        List<Author> authorList = authorRepository.findAll();
        if(authorList.isEmpty())
            return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);

        return  new ResponseEntity<List<Author>>(authorList,HttpStatus.OK);
    }
}
