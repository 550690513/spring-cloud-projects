package com.cheung.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Log消息生产者
 *
 * @author Cheung
 */
@Component
public class MqSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	/**
	 * 交换器
	 */
	@Value("${mq.config.exchange}")
	private String exchange;

	/**
	 * 发送消息
	 *
	 * @param msg
	 */
	public void send(String msg) {
		/*
		 * 参数一：交换器名称
		 * 参数二：路由键
		 * 参数三：消息
		 */
		this.amqpTemplate.convertAndSend(this.exchange, "", msg);// fanout广播模式，没有路由键，以“广播”的模式发布消息到所有队列
		System.out.printf("MqSender：%s\r\n", msg);
	}

}
