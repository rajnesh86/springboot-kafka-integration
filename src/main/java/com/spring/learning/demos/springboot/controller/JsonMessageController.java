package com.spring.learning.demos.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learning.demos.springboot.dto.Employee;
import com.spring.learning.demos.springboot.kafka.JsonKafkaProducer;

/**
 * Controller class for handling JSON messages with Kafka. This class defines
 * RESTful endpoints related to JSON message publishing.
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	private JsonKafkaProducer producer;

	/**
	 * Constructs a new {@code JsonMessageController} with the specified Kafka
	 * producer.
	 *
	 * @param producer The JSON Kafka producer used for sending messages.
	 */
	public JsonMessageController(JsonKafkaProducer producer) {
		this.producer = producer;
	}

	/**
	 * Handles HTTP POST requests to publish JSON messages to Kafka.
	 *
	 * @param employee The Employee object representing the JSON message.
	 * @return A ResponseEntity with a success message upon successful message
	 *         publication.
	 */
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody Employee employee) {
		producer.sendMessage(employee);
		return ResponseEntity.ok("Message sent in JSON Format");
	}
}
