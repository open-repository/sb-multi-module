package io.nio.publisher.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PublisherDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublisherDiscoveryApplication.class, args);
    }

}
