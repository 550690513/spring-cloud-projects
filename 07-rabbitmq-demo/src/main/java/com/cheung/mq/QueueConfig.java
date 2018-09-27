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

		/**
		 * String name：队列名称
		 * boolean durable：是否持久化（默认true）
		 * boolean exclusive：是否排外（默认false）
		 * boolean autoDelete：是否自动删除（默认false）
		 */
		// Queue queue = new Queue(QueueConfig.QUEUE_NAME, true, false, true);
		Queue queue = new Queue(QueueConfig.QUEUE_NAME);
		return queue;
	}

}
