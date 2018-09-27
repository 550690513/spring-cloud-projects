package com.cheung;

import com.cheung.mq.OrderLogMqSender;
import com.cheung.mq.ProductLogMqSender;
import com.cheung.mq.UserLogMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProducerApplication.class})
public class ProducerApplicationTests {

	@Autowired
	private UserLogMqSender userLogMqSender;

	@Autowired
	private ProductLogMqSender productLogMqSender;

	@Autowired
	private OrderLogMqSender orderLogMqSender;

	@Test
	public void testSend() {
		// 测试发送user服务产生的不同级别log
		this.userLogMqSender.send(UserLogMqSender.USER_LOG_DEBUG, "user服务产生的debug级别log");
		this.userLogMqSender.send(UserLogMqSender.USER_LOG_INFO, "user服务产生的info级别log");
		this.userLogMqSender.send(UserLogMqSender.USER_LOG_WARN, "user服务产生的warn级别log");
		this.userLogMqSender.send(UserLogMqSender.USER_LOG_ERROR, "user服务产生的error级别log");


		// 测试发送product服务产生的不同级别log
		this.productLogMqSender.send(ProductLogMqSender.PRODUCT_LOG_DEBUG, "product服务产生的debug级别log");
		this.productLogMqSender.send(ProductLogMqSender.PRODUCT_LOG_INFO, "product服务产生的info级别log");
		this.productLogMqSender.send(ProductLogMqSender.PRODUCT_LOG_WARN, "product服务产生的warn级别log");
		this.productLogMqSender.send(ProductLogMqSender.PRODUCT_LOG_ERROR, "product服务产生的error级别log");

		// 测试发送order服务产生的不同级别log
		this.orderLogMqSender.send(OrderLogMqSender.ORDER_LOG_DEBUG, "order服务产生的debug级别log");
		this.orderLogMqSender.send(OrderLogMqSender.ORDER_LOG_INFO, "order服务产生的info级别log");
		this.orderLogMqSender.send(OrderLogMqSender.ORDER_LOG_WARN, "order服务产生的warn级别log");
		this.orderLogMqSender.send(OrderLogMqSender.ORDER_LOG_ERROR, "order服务产生的error级别log");
	}


}
