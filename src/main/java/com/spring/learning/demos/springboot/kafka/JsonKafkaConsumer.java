package com.spring.learning.demos.springboot.kafka;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.spring.learning.demos.springboot.dto.Employee;

/**
 * Service class for consuming JSON messages from a Kafka topic.
 */
@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JsonKafkaConsumer.class);

	/**
	 * Kafka listener method that consumes JSON messages from the specified topic.
	 *
	 * @param employee The Employee object received from the Kafka topic.
	 */
	@KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(Employee employee) {
		LOGGER.info(String.format("Message received: %s", employee.toString()));
	}
}
