package io.nio.publisher.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.nio")
public class PublisherAuthorMaintenanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublisherAuthorMaintenanceApplication.class, args);
    }

}
