package com.cheung.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * LogMq 消息生产者
 *
 * @author Cheung
 */
@Component
public class LogMqSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	/**
	 * 交换器
	 */
	@Value("${mq.config.exchange}")
	private String exchange;

	/**
	 * log队列路由键
	 */
	@Value("${mq.config.queue.log.routing.key}")
	private String logRoutingKey;


	/**
	 * 发送消息
	 *
	 * @param msg
	 */
	public void sendMqForLog(String msg) {
		/*
		 * 参数一：交换器名称
		 * 参数二：路由键
		 * 参数三：消息
		 */
		this.amqpTemplate.convertAndSend(this.exchange, this.logRoutingKey, msg);
		System.out.printf("LogMqSender：%s\r\n", msg);
	}


}
