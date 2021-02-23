package com.quarkusmongo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ExampleResource {

    @GetMapping
    public String hello() {
        return "Hello Spring";
    }
}
