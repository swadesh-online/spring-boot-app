package com.veinchain.rest.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.auto-create-topic-name}")
    private String topicName;



    @Bean
    public NewTopic createNewTopic() {
        return new NewTopic(topicName, 1, (short) 1);
    }

    @Bean
    public NewTopic createInputTopic() {
        return new NewTopic("input-topic", 1, (short) 1);
    }

    @Bean
    public NewTopic createOutputTopic() {
        return new NewTopic("output-topic", 1, (short) 1);

    }



}
