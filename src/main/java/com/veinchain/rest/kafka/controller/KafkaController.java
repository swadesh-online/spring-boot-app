package com.veinchain.rest.kafka.controller;

import com.veinchain.rest.kafka.producer.KafkaProducer;
import com.veinchain.rest.kafka.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getResponse(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>(ApiResponse.build(true, "Successfully published.", message), HttpStatus.OK);
    }

    @PostMapping("/stream")
    public ResponseEntity<ApiResponse> getResponse2(@RequestParam String message) {
        kafkaProducer.sendMessageToStream(message);
        return new ResponseEntity<>(ApiResponse.build(true, "Successfully published.", message), HttpStatus.OK);
    }
}
