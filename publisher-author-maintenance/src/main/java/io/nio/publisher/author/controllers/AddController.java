package io.nio.publisher.author.controllers;

import io.nio.library.service.Service;
import io.nio.publisher.author.entity.Author;
import io.nio.publisher.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/author")
public class AddController {

    private AuthorRepository authorRepository;
    private Service service;

    @Autowired
    public void AuthorRepository(AuthorRepository authorRepository,Service service) {
        this.authorRepository=authorRepository;
        this.service=service;
    }

    @GetMapping("")
    public String homePath(){
        return service.message();
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


}
