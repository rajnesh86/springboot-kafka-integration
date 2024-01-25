/**
 *
 */
package com.spring.learning.demos.springboot.kafka;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The {@code KafkaProducer} class provides functionality for producing and
 * sending messages to a Kafka topic.
 * <p>
 * This class is annotated with {@code @Service} to indicate that it is a
 * Spring-managed service component. It utilizes a {@code KafkaTemplate} for
 * sending messages to the specified Kafka topic.
 * </p>
 *
 * <p>
 * Usage example:
 *
 * <pre>
 * {
 * 	&#64;code
 * 	KafkaProducer kafkaProducer = new KafkaProducer(kafkaTemplate);
 * 	kafkaProducer.sendMessage("Hello, Kafka!");
 * }
 * </pre>
 * </p>
 *
 * <p>
 * This class assumes that the provided {@code KafkaTemplate} has been properly
 * configured with the necessary Kafka producer properties and connection
 * details for interacting with a Kafka broker.
 * </p>
 *
 * <p>
 * The Kafka topic to which messages are sent is specified as "javaguides".
 * Messages are logged using SLF4J logging.
 * </p>
 *
 * <p>
 * <b>Note:</b> It is essential to configure the KafkaTemplate with the
 * appropriate serializers and connection details to ensure proper communication
 * with the Kafka broker.
 * </p>
 *
 * @version 1.0
 * @see org.springframework.kafka.core.KafkaTemplate
 * @see org.slf4j.Logger
 * @see org.springframework.stereotype.Service
 */
@Service
public class KafkaProducer {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Constructs a {@code KafkaProducer} instance with the provided
     * {@code KafkaTemplate}.
     *
     * @param kafkaTemplate The KafkaTemplate instance used for sending messages to
     *                      Kafka.
     */
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Sends a message to the configured Kafka topic using the underlying
     * KafkaTemplate.
     *
     * @param message The message to be sent to the Kafka topic.
     */
    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent: %s", message));
        kafkaTemplate.send(topicName, message);
    }
}
