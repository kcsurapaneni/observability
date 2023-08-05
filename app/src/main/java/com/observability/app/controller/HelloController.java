package com.observability.app.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    Hello getMessage(@RequestParam String name) {
        logger.info("getMessage() is called");
        return new Hello("Hello, " + name);
    }


    record Hello(String text) {
    }

}
