package com.cheung.mq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * LogMq 消息消费者
 * *
 * * @RabbitListener
 * *     bindings:绑定 @QueueBinding
 * *                        value:绑定队列 @Queue
 * *                                         value:队列名称
 * *                                         autoDelete:当所有消费客户端连接断开后，是否自动删除队列 true：删除   false：不删除（持久化）
 * *                        exchange:配置交换器 @Exchange
 * *                                         value:交换器名称
 * *                                         type:指定具体的交换器类型
 * *                                         autoDelete：当所有绑定队列都不再使用时，是否自动删除交换器 true：删除   false：不删除（持久化）
 * *                        key:配置路由键
 * *
 *
 * @author Cheung
 */
@Component
@RabbitListener(
		bindings = @QueueBinding(
				value = @Queue(value = "${mq.config.queue.log}", autoDelete = "true"),
				exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT),
				key = "${mq.config.queue.log.routing.key}"
		)
)
public class LogMqReceiver {

	/**
	 * 接收消息，采用消息队列监听机制
	 *
	 * @param msg
	 */
	@RabbitHandler
	public void process(String msg) {
		System.out.printf("LogMqReceiver：%s\r\n", msg);
		throw new RuntimeException("模拟异常。。。");

	}

}
