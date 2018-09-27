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
public class LogMqSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	/**
	 * 交换器
	 */
	@Value("${mq.config.exchange}")
	private String exchange;

	/**
	 * info队列路由键
	 */
	@Value("${mq.config.queue.info.routing.key}")
	private String infoRoutingKey;

	/**
	 * error队列路由键
	 */
	@Value("${mq.config.queue.error.routing.key}")
	private String errorRoutingKey;

	/**
	 * 发送info消息
	 *
	 * @param msg
	 */
	public void sendMqForInfoLog(String msg) {
		/*
		 * 参数一：交换器名称
		 * 参数二：路由键
		 * 参数三：消息
		 */
		this.amqpTemplate.convertAndSend(this.exchange, this.infoRoutingKey, msg);
		System.out.printf("InfoLogMqSender发送：%s\r\n", msg);
	}

	/**
	 * 发送error消息
	 *
	 * @param msg
	 */
	public void sendMqForErrorLog(String msg) {
		/*
		 * 参数一：交换器名称
		 * 参数二：路由键
		 * 参数三：消息
		 */
		this.amqpTemplate.convertAndSend(this.exchange, this.errorRoutingKey, msg);
		System.out.printf("ErrorLogMqSender发送：{%s}\r\n", msg);
	}


}
