package com.kafka.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerMessage {
	Logger LOG = LoggerFactory.getLogger(ConsumerMessage.class);

	@KafkaListener(topics = "reflectoring-1")
	void listener(String data) {
		LOG.info(data);
	}

	@KafkaListener(
		topics = "reflectoring-1, reflectoring-2",
		groupId = "reflectoring-group-2")
	void commonListenerForMultipleTopics(String message) {
		LOG.info("MultipleTopicListener - {}", message);
	}
}
