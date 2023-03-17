package com.dilip.rabbit.msg;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queueName; //teste-DCH-Test3
	
	@Value("${rabbitmq.queue2.name}")
	private String queueName2; //teste2
	
	@Bean
	public Queue queue() {
		System.out.println("Queue "+ this.queueName + " is getting set...");
		return new Queue(this.queueName, true);
	}
	
	@Bean
	public Queue queueSecond() {
		System.out.println("Queue "+ this.queueName2 + " is getting set...");
		return new Queue(this.queueName2, true);
	}
	
}
