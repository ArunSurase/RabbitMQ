package com.rabbitmq.demo.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.demo.entity.Employee;

@Component
public class ConsumerConfig {
	
	@RabbitListener(queues = ProducerConfig.QUEUE)
	public void messageConsumed(Employee employee) {
		System.out.println("Message consumed!");
		System.out.println(employee);
	}

}
