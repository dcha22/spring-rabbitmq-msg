package com.dilip.rabbit.msg;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class QueueSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	private Queue queueSecond;

	// This will send the given message to the given queue in RabbitMQ
	public void send(String order) throws InterruptedException {
		rabbitTemplate.convertAndSend(this.queue.getName(), order);
	}

	// This will send the given message to the given queue in RabbitMQ
	public void send2(String order) throws InterruptedException {
		rabbitTemplate.convertAndSend(this.queueSecond.getName(), order);
	}
}
