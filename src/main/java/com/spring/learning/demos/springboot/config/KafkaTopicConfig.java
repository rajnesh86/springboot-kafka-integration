package com.spring.learning.demos.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * The {@code KafkaTopicConfig} class is a Spring configuration class
 * responsible for defining Kafka topics.
 * <p>
 * It uses Spring Kafka's {@code TopicBuilder} to create new Kafka topics named
 * "topic-one" and "json-topic" with default settings. This class is annotated
 * with {@code @Configuration} to indicate that it contains bean definitions for
 * Kafka topics.
 * </p>
 *
 * <p>
 * Usage example:
 *
 * <pre>
 * {
 * 	&#64;code
 * 	&#64;Autowired
 * 	private KafkaTopicConfig kafkaTopicConfig;
 *
 * // Access the 'topic-one' and 'json-topic' topic configurations
 * 	NewTopic topicOne = kafkaTopicConfig.topicOne();
 * 	NewTopic jsonTopic = kafkaTopicConfig.jsonTopic();
 * }
 * </pre>
 * </p>
 *
 * <p>
 * This class assumes that it is part of a Spring application with appropriate
 * Kafka configurations.
 * </p>
 *
 * <p>
 * <b>Note:</b> It is crucial to ensure that Kafka topics are properly
 * configured based on the requirements of the application and the Kafka broker
 * setup.
 * </p>
 *
 * @see org.apache.kafka.clients.admin.NewTopic
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.kafka.config.TopicBuilder
 * @see org.springframework.kafka.core.KafkaAdmin
 * @see org.springframework.kafka.core.KafkaTemplate
 */
@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String jsonTopicName;

    /**
     * Defines a new Kafka topic named "topic-one" using the default settings
     * provided by {@code TopicBuilder}.
     *
     * @return A {@code NewTopic} instance representing the "topic-one" Kafka topic.
     */
    @Bean
    public NewTopic topicOne() {
        return TopicBuilder.name(topicName).build();
    }

    /**
     * Defines a new Kafka topic named "json-topic" using the default settings
     * provided by {@code TopicBuilder}.
     *
     * @return A {@code NewTopic} instance representing the "json-topic" Kafka
     * topic.
     */
    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name(jsonTopicName).build();
    }
}
