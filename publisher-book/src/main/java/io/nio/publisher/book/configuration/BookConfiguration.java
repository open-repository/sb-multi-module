package io.nio.publisher.book.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BookConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate httpClient(){
        return new RestTemplate();

    }


}
