package com.spring.learning.demos.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learning.demos.springboot.kafka.KafkaProducer;

/**
 * Controller class for handling Kafka messaging related requests.
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    /**
     * Constructor to initialize the MessageController with a KafkaProducer instance.
     *
     * @param kafkaProducer The KafkaProducer instance used to send messages to Kafka.
     */
    @Autowired
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    /**
     * Handles GET requests to publish a message to the Kafka topic.
     *
     * @param message The message to be published to the Kafka topic.
     * @return ResponseEntity with a success message if the message is sent successfully.
     */
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}