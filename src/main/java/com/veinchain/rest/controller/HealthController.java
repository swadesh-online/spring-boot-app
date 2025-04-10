package com.veinchain.rest.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity healthCheck() {
        return new ResponseEntity<>(Map.of("message","Hey Animals!"), HttpStatusCode.valueOf(200));
    }
}
