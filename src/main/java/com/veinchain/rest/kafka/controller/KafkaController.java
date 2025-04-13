package com.veinchain.rest.kafka.controller;

import com.veinchain.rest.kafka.producer.KafkaProducer;
import com.veinchain.rest.kafka.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<ApiResponse> getResponse(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>(ApiResponse.build(true, "Successfully published.", message), HttpStatus.OK);
    }
}
