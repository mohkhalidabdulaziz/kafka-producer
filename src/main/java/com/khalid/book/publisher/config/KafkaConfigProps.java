package com.khalid.book.publisher.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "khalid.kafka")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KafkaConfigProps {

    private String topic;

}
