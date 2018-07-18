package com.cheung.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 *
 * @author Cheung
 */
@Component
public class MqReceiver {

	/**
	 * 接收消息，采用消息队列监听机制
	 *
	 * @param msg
	 */
	@RabbitListener(queues = {QueueConfig.QUEUE_NAME})
	public void process(String msg) {
		System.out.printf("receiver：%s\r\n", msg);

	}

}
