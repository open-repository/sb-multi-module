package io.nio.publisher.book.entity;

import io.nio.publisher.author.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long ISBN;
    private String book_name;
    private String publisher;
    private List<Author> authors;

}
