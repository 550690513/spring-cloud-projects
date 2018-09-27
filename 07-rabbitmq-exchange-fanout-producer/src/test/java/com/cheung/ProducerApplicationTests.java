package com.cheung;

import com.cheung.mq.OrderMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProducerApplication.class})
public class ProducerApplicationTests {

	@Autowired
	private OrderMqSender orderMqSender;

	@Test
	public void testSend() {
		this.orderMqSender.send("用户下单成功发送的mq消息");
	}

}
