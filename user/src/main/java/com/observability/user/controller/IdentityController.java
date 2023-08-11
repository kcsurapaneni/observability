package com.observability.user.controller;

import com.observability.user.dto.*;
import com.observability.user.service.*;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/identity")
public class IdentityController {

    private static final Logger logger = LoggerFactory.getLogger(IdentityController.class);

    private final UserService userService;

    public IdentityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    UserDTO getIdentity(@RequestParam int id) {
        logger.info("User Id : {}", id);
        return userService.getUserData(id);
    }

}
