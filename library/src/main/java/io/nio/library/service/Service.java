package io.nio.library.service;

import io.nio.library.configuration.ServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@org.springframework.stereotype.Service
@EnableConfigurationProperties(ServiceProperties.class)
public class Service {

    private final ServiceProperties serviceProperties;

    public Service(ServiceProperties serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    public String message() {
        return this.serviceProperties.getMessage();
    }
}
