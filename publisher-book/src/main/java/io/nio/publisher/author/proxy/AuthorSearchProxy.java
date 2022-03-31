package io.nio.publisher.author.proxy;

import io.nio.publisher.author.entity.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "PUBLISHER-AUTHOR-SEARCH")

public interface AuthorSearchProxy {
        @GetMapping("author/search/isbn/{isbn}")
        public ResponseEntity<List<Author>> findAllAuthorsByISBN(@PathVariable long isbn);
}
