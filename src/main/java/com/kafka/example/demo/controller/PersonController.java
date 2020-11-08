package com.kafka.example.demo.controller;

import com.kafka.example.demo.service.PublishMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class PersonController {

	private final PublishMessageService publishMessage;

	@Autowired
	public PersonController(final PublishMessageService publishMessage) {
		this.publishMessage = publishMessage;
	}

	@PostMapping(consumes = {"application/json"},produces = {"application/json"})
	public void publishMessage(@RequestBody String body) {
		System.out.println("messages::: "+body);
		this.publishMessage.sendMessage(body, "myTopic");
	}
}
