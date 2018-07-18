package com.cheung.mq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * App推送服务 消息消费者
 * *
 * * @RabbitListener
 * *     bindings:绑定 @QueueBinding
 * *                        value:绑定队列 @Queue
 * *                                         value:队列名称
 * *                                         autoDelete:是否是一个可删除的临时队列
 * *                        exchange:配置交换器 @Exchange
 * *                                         value:交换器名称
 * *                                         type:指定具体的交换器类型
 * *                        key:配置路由键（fanout广播模式，队列不设置路由键，接收来自以“广播”的模式发布的所有的消息）
 * *
 *
 * @author Cheung
 */
@Component
@RabbitListener(
		bindings = @QueueBinding(
				value = @Queue(value = "${mq.config.queue.push}", autoDelete = "true"),
				exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.FANOUT)
		)
)
public class PushReceiver {

	/**
	 * 接收消息，采用消息队列监听机制
	 *
	 * @param msg
	 */
	@RabbitHandler
	public void process(String msg) {
		System.out.printf("PushReceiver：%s\r\n", msg);

	}

}
