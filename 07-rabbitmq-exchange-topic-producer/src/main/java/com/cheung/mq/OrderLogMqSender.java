package com.cheung.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 订单Log消息生产者
 *
 * @author Cheung
 */
@Component
public class OrderLogMqSender {

	public static final String ORDER_LOG_DEBUG = "order.log.debug";
	public static final String ORDER_LOG_INFO = "order.log.info";
	public static final String ORDER_LOG_WARN = "order.log.warn";
	public static final String ORDER_LOG_ERROR = "order.log.error";


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
	 * @param routingKey
	 * @param msg
	 */
	public void send(String routingKey, String msg) {
		/*
		 * 参数一：交换器名称
		 * 参数二：路由键
		 * 参数三：消息
		 */
		this.amqpTemplate.convertAndSend(this.exchange, routingKey, msg);
		System.out.printf("OrderLogSender发送：{%s}，（路由键：%s）\r\n", msg, routingKey);
	}

}
