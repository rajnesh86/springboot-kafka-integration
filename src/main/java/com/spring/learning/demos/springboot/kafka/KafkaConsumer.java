package com.spring.learning.demos.springboot.kafka;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Service class for consuming messages from a Kafka topic.
 */
@Service
public class KafkaConsumer {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(KafkaConsumer.class);

	/**
	 * Kafka listener method that consumes messages from the specified topic.
	 *
	 * @param message The message received from the Kafka topic.
	 */
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String message) {
		LOGGER.info(String.format("Message received: %s", message));
	}
}
