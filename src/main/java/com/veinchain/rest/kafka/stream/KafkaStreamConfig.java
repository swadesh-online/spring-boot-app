package com.veinchain.rest.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaStreamConfig {

    @Bean
    public KStream<String, String> kStreamProcessor(StreamsBuilder builder) {
        KStream<String, String> stream = builder.stream("input-topic", Consumed.with(Serdes.String(), Serdes.String()));

                stream
                .mapValues(value -> String.join(":", value.toUpperCase(), String.valueOf(value.length())))
                .to("output-topic", Produced.with(Serdes.String(), Serdes.String()));

        return stream;
    }
}