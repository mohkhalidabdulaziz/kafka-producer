package com.khalid.bookpublisher.services.implementation;

import com.khalid.bookpublisher.config.KafkaConfigProps;
import com.khalid.bookpublisher.domain.Book;
import com.khalid.bookpublisher.exception.BookPublishException;
import com.khalid.bookpublisher.services.BookPublisherService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Publishes books to a Kafka topic.
 */
@Service
public class KafkaBookPublisherService implements BookPublisherService {

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaConfigProps kafkaConfigProps;

    public KafkaBookPublisherService(
            final ObjectMapper objectMapper,
            final KafkaTemplate<String, String> kafkaTemplate,
            final KafkaConfigProps kafkaConfigProps) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigProps = kafkaConfigProps;
    }

    @Override
    public void publish(final Book book) {
        try {
            final String payload = objectMapper.writeValueAsString(book);
            kafkaTemplate.send(kafkaConfigProps.getTopic(), payload);
        } catch (final JsonProcessingException ex) {
            throw new BookPublishException("Unable to publish book", ex, book);
        }
    }

}
