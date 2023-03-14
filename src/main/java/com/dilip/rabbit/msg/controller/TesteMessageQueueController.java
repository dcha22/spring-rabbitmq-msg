package com.dilip.rabbit.msg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.rabbit.msg.QueueSender;

@RestController
//@RequestMapping("/teste-DCH")
public class TesteMessageQueueController {
	
	@Autowired
	private QueueSender queueSender;
	
	@GetMapping("/rabbitmsg")
	public String send() throws InterruptedException {
		queueSender.send("This is test message");
		return "ok.finished";
	}
	
	@GetMapping("/rabbitmsg2")
	public String send2() throws InterruptedException {
		queueSender.send2("This is test message2-queue2");
		return "ok.finished";
	}
	
	@PostMapping("/rabbitmsg2")
	public String send2(@RequestBody String msg) throws InterruptedException {
		queueSender.send(msg);
		return "ok.posted";
	}
}
