package io.nio.publisher.author.repository;

import io.nio.publisher.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    List<Author> findAllByISBN(long isbn);
}
