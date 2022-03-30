package io.nio.publisher.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PublisherAuthorSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublisherAuthorSearchApplication.class, args);
    }

}
