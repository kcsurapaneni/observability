package com.observability.user.service;

import com.observability.user.dto.*;
import com.observability.user.model.*;
import com.observability.user.repository.*;
import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

/**
 * @author Krishna Chaitanya
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public UserDTO getUserData(final int id) {
        User user = userRepository.findById(id).orElseThrow();
        var appApiHealthCheckResponse = restTemplate.getForEntity("http://local-app-api:8080/app/actuator/health", String.class).getBody();
        logger.info("app api health check response - {}", appApiHealthCheckResponse);
        for (UserComment userComment : user.getUserCommentList()) {
            logger.info("comment : {}", userComment);
        }
        logger.info("user found from database");
        return User.to(user);
    }

}
