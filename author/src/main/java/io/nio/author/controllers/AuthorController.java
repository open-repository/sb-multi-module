package io.nio.author.controllers;

import io.nio.author.entity.Author;
import io.nio.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public void AuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository=authorRepository;
    }

    @GetMapping("")
    public String homePath(){
        return "OK";
    }

    @PostMapping("")
    public Author addAuthor(@RequestBody Author author){
        Author authorResponse = authorRepository.save(author);
        return authorResponse;
    }

    @DeleteMapping("/{id}")
    public void removeAuthor(@PathVariable long id){
        authorRepository.deleteById(id);

    }


    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<List<Author>> findByISBN(@PathVariable long isbn){

        List<Author> authorList = authorRepository.findAllByISBN(isbn);
        if(authorList.isEmpty())
            return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);

        return  new ResponseEntity<List<Author>>(authorList,HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Author>> findAll(){
        List<Author> authorList = authorRepository.findAll();
        if(authorList.isEmpty())
            return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);

        return  new ResponseEntity<List<Author>>(authorList,HttpStatus.OK);
    }

}
