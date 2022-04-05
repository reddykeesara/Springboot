package com.rag.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {// implements MessageListener {
//	@RabbitListener(queues = "ragnet.queue")
//	public void consumeMessage(Employee s) {
//		System.out.println(s.toString());
//	}

//	@Override
//	public void onMessage(Message message) {
//		System.out.println(new String(message.getBody()));
//	}
}
