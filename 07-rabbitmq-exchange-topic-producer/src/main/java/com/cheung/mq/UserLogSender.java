package com.cheung.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户Log消息生产者
 *
 * @author Cheung
 */
@Component
public class UserLogSender {

	private static final String USER_LOG_DEBUG = "user.log.debug";
	private static final String USER_LOG_INFO = "user.log.info";
	private static final String USER_LOG_WARN = "user.log.warn";
	private static final String USER_LOG_ERROR = "user.log.error";

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
		this.amqpTemplate.convertAndSend(this.exchange, USER_LOG_DEBUG, USER_LOG_DEBUG + "-" + msg);
		System.out.printf("UserLogSender：%s\r\n", USER_LOG_DEBUG + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, USER_LOG_INFO, USER_LOG_INFO + "-" + msg);
		System.out.printf("UserLogSender：%s\r\n", USER_LOG_INFO + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, USER_LOG_WARN, USER_LOG_WARN + "-" + msg);
		System.out.printf("UserLogSender：%s\r\n", USER_LOG_WARN + "-" + msg);
		this.amqpTemplate.convertAndSend(this.exchange, USER_LOG_ERROR, USER_LOG_ERROR + "-" + msg);
		System.out.printf("UserLogSender：%s\r\n", USER_LOG_ERROR + "-" + msg);
	}

}
