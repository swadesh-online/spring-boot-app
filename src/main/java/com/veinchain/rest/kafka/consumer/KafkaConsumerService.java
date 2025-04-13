package com.veinchain.rest.kafka.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Value("${spring.kafka.auto-create-topic-name}")
    public String topicName;

    @KafkaListener(topics = "#{__listener.topicName}", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "output-topic", groupId = "my-group")
    public void listenToStream(String message) {
        System.out.println("Received message from Stream: " + message);
    }
}