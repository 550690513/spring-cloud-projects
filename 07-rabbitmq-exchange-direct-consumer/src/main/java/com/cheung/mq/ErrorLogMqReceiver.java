package com.cheung.mq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ErrorLog消息消费者
 * *
 * * @RabbitListener
 * *     bindings:绑定 @QueueBinding
 * *                        value:绑定队列 @Queue
 * *                                         value:队列名称
 * *                                         autoDelete:是否是一个可删除的临时队列
 * *                        exchange:配置交换器 @Exchange
 * *                                         value:交换器名称
 * *                                         type:指定具体的交换器类型
 * *                        key:配置路由键
 * *
 *
 * @author Cheung
 */
@Component
@RabbitListener(
		bindings = @QueueBinding(
				value = @Queue(value = "${mq.config.queue.error}", autoDelete = "true"),
				exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT),
				key = "${mq.config.queue.error.routing.key}"
		)
)
public class ErrorLogMqReceiver {

	/**
	 * 接收消息，采用消息队列监听机制
	 *
	 * @param msg
	 */
	@RabbitHandler
	public void process(String msg) {
		System.out.printf("ErrorLogMqReceiver接收到：{%s}\r\n", msg);

	}

}
