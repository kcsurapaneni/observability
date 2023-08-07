package com.observability.app.service;

import com.observability.app.dto.*;
import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

/**
 * @author Krishna Chaitanya
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO fetchUser(final int id) {
        logger.info("Calling Rest Template with id : {}", id);
        return restTemplate.getForEntity("http://local-user-api:8081/user/identity?id=" + id, UserDTO.class).getBody();
    }

}
