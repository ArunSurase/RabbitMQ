package com.rabbitmq.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.demo.configuration.ProducerConfig;
import com.rabbitmq.demo.entity.Employee;

@RestController
@RequestMapping("/rest/api")
public class ProducerController {
	
	@Autowired
	RabbitTemplate rabbitTemplate;

	@PostMapping("/publisher")
	public String publisher(@RequestBody Employee employee) {
		employee.setId(1002);
		rabbitTemplate.convertAndSend(ProducerConfig.EXCHANGE,ProducerConfig.ROUTING_KEY, employee);
		return "record published successfully!";
	}
}
