package com.dilip.rabbit.msg;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

// This will consume the messages from RabbitMQ
// If this is not running for some reason, then all the 
// messages will be sitting in the queue, unless some other app consumes 
// them. 
// Try by commenting @Component annotation
@Component
public class QueueConsumer {
	
	/*
	 * @RabbitListener - Annotation that marks a method to be 
	 * the target of a Rabbit message listener on the specified 
	 * queue. Here you can specify multiple queues.
	 * 
	 * Hence, whenever there is a message on the given queue (specified by
	 * ${queue.name}), this method will be invoked.
	 */
	@RabbitListener(queues = {"${rabbitmq.queue.name}", "${rabbitmq.queue2.name}", "${rabbitmq.pyqueue.name}"})
	//@RabbitListener(queues = {"${rabbitmq.queue.name}", "${rabbitmq.queue2.name}"})
	public void receive(@Payload String body) {
		System.out.println("Messge:  "+ body);
	}
}
