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
public class OrderLogSender {

	private static final String ORDER_LOG_DEBUG = "order.log.debug";
	private static final String ORDER_LOG_INFO = "order.log.info";
	private static final String ORDER_LOG_WARN = "order.log.warn";
	private static final String ORDER_LOG_ERROR = "order.log.error";


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
		this.amqpTemplate.convertAndSend(this.exchange, ORDER_LOG_DEBUG, ORDER_LOG_DEBUG + "-" + msg);
		System.out.printf("OrderLogSender：%s\r\n", ORDER_LOG_DEBUG + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, ORDER_LOG_INFO, ORDER_LOG_INFO + "-" + msg);
		System.out.printf("OrderLogSender：%s\r\n", ORDER_LOG_INFO + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, ORDER_LOG_WARN, ORDER_LOG_WARN + "-" + msg);
		System.out.printf("OrderLogSender：%s\r\n", ORDER_LOG_WARN + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, ORDER_LOG_ERROR, ORDER_LOG_ERROR + "-" + msg);
		System.out.printf("OrderLogSender：%s\r\n", ORDER_LOG_ERROR + "-" + msg);
	}

}
