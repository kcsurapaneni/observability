package com.observability.app.controller;

import com.observability.app.dto.*;
import com.observability.app.service.*;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    User getUser(@RequestParam int id) {
        logger.info("getUser() is called");
        logger.info("calling userService.fetchUser(id)");
        return userService.fetchUser(id);
    }


}
