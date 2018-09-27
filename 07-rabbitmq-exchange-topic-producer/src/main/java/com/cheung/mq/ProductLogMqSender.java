package com.cheung.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 商品Log消息生产者
 *
 * @author Cheung
 */
@Component
public class ProductLogMqSender {

	public static final String PRODUCT_LOG_DEBUG = "product.log.debug";
	public static final String PRODUCT_LOG_INFO = "product.log.info";
	public static final String PRODUCT_LOG_WARN = "product.log.warn";
	public static final String PRODUCT_LOG_ERROR = "product.log.error";

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
		System.out.printf("ProductLogSender发送：{%s}，（路由键：%s）\r\n", msg, routingKey);
	}

}
