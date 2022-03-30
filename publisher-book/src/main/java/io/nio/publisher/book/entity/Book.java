package io.nio.publisher.book.entity;

import io.nio.publisher.author.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private long ISBN;
    private String book_name;
    private String publisher;
    private List<Author> authors;

}
