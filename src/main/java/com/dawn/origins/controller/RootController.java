package com.dawn.origins.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @RestController
    public class HomeController {
        @GetMapping("/docs")
        public ResponseEntity<Void> redirectToSwagger() {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("/swagger-ui.html"))
                    .build();
        }
    }
}
