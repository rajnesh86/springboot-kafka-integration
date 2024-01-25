package com.spring.learning.demos.springboot.kafka;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.spring.learning.demos.springboot.dto.Employee;

/**
 * Service class for producing JSON messages to a Kafka topic.
 */
@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JsonKafkaProducer.class);

	private final KafkaTemplate<String, Employee> kafkaTemplate;

	@Value("${spring.kafka.topic-json.name}")
	private String jsonTopicName;

	/**
	 * Constructs a new {@code JsonKafkaProducer} with the specified Kafka template.
	 *
	 * @param kafkaTemplate The Kafka template used for sending messages.
	 */
	public JsonKafkaProducer(KafkaTemplate<String, Employee> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	/**
	 * Sends a JSON message to the configured Kafka topic.
	 *
	 * @param employee The Employee object representing the JSON message.
	 */
	public void sendMessage(Employee employee) {
		LOGGER.info(String.format("Message sent: %s", employee.toString()));

		Message<Employee> message = MessageBuilder
													.withPayload(employee)
													.setHeader(KafkaHeaders.TOPIC, jsonTopicName)
													.build();

		kafkaTemplate.send(message);
	}
}
