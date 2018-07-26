package com.cheung.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 项目启动时就创建一个消息队列
 * <p>
 * Spring Boot在启动时，会对所有以@Configuration注解的类进行实例化，同时会执行该类下所有以@Bean注解的方法，并将方法返回值自动注入到Spring IOC容器当中。
 *
 * @author Cheung
 */
@Configuration
public class QueueConfig {

	public static final String QUEUE_NAME = "hello-queue";

	/**
	 * 创建队列
	 *
	 * @return
	 */
	@Bean
	public Queue createQueue() {
		return new Queue(QueueConfig.QUEUE_NAME);
	}

}
