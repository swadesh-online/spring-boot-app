package com.veinchain.rest.kafka.controller;

import com.veinchain.rest.kafka.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @GetMapping
    public ResponseEntity<ApiResponse> getResponse() {
        return new ResponseEntity<>(ApiResponse.build(true, "msg", null), HttpStatus.OK);
    }
}
