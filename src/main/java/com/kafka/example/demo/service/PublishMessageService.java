package com.kafka.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishMessageService {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	PublishMessageService(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(final Object message, final String topicName) {
		this.kafkaTemplate.send(topicName, message);
	}
}
