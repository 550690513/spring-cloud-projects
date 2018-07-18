package com.cheung.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 *
 * @author Cheung
 */
@Component
public class MqSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	/**
	 * 发送消息
	 *
	 * @param msg
	 */
	public void send(String msg) {
		/*
		 * 参数一：队列名称
		 * 参数二：消息
		 */
		this.amqpTemplate.convertAndSend(QueueConfig.QUEUE_NAME, msg);
		System.out.printf("sender：%s\r\n", msg);
	}

}
