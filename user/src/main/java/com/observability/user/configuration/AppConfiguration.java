package com.observability.user.configuration;

import org.springframework.boot.web.client.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

/**
 * @author Krishna Chaitanya
 */
@Configuration
public class AppConfiguration {

    // It is important to use RestTemplateBuilder when building the restTemplate
    // for propagating trace id from one api to another
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
