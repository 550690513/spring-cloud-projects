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

	private static final String PRODUCT_LOG_DEBUG = "product.log.debug";
	private static final String PRODUCT_LOG_INFO = "product.log.info";
	private static final String PRODUCT_LOG_WARN = "product.log.warn";
	private static final String PRODUCT_LOG_ERROR = "product.log.error";

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
		this.amqpTemplate.convertAndSend(this.exchange, PRODUCT_LOG_DEBUG, PRODUCT_LOG_DEBUG + "-" + msg);
		System.out.printf("ProductLogSender：%s\r\n", PRODUCT_LOG_DEBUG + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, PRODUCT_LOG_INFO, PRODUCT_LOG_INFO + "-" + msg);
		System.out.printf("ProductLogSender：%s\r\n", PRODUCT_LOG_INFO + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, PRODUCT_LOG_WARN, PRODUCT_LOG_WARN + "-" + msg);
		System.out.printf("ProductLogSender：%s\r\n", PRODUCT_LOG_WARN + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, PRODUCT_LOG_ERROR, PRODUCT_LOG_ERROR + "-" + msg);
		System.out.printf("ProductLogSender：%s\r\n", PRODUCT_LOG_ERROR + "-" + msg);
	}

}
