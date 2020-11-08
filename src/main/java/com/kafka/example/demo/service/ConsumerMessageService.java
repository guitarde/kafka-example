package com.kafka.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerMessageService {
	Logger LOG = LoggerFactory.getLogger(ConsumerMessageService.class);

	@KafkaListener(topics = "${spring.kafka.consumer.topic}")
	void listener(@Payload Object data) {
		System.out.println("Message recive: " + data);
	}

	@KafkaListener(
		topics = "reflectoring-1, reflectoring-2",
		groupId = "reflectoring-group-2")
	void commonListenerForMultipleTopics(String message) {
		LOG.info("MultipleTopicListener - {}", message);
	}
}
