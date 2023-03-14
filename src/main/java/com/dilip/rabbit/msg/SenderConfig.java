package com.dilip.rabbit.msg;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String message;
	
	@Value("${rabbitmq.queue2.name}")
	private String message2;
	
	@Bean
	public Queue queue() {
		System.out.println("Queue "+ this.message + " is getting set...");
		return new Queue(this.message, true);
	}
	
	@Bean
	public Queue queueSecond() {
		System.out.println("Queue "+ this.message2 + " is getting set...");
		return new Queue(this.message2, true);
	}
	
}
