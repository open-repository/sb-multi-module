package io.nio.author.proxy;

import io.nio.author.entity.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "AUTHOR")

public interface AuthorSearchProxy {
        @GetMapping("author/search/isbn/{isbn}")
        public ResponseEntity<List<Author>> findAllAuthorsByISBN(@PathVariable long isbn);
}
