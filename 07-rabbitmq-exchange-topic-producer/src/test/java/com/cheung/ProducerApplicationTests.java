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
	public void testSend() throws InterruptedException {
		this.userLogMqSender.send("test user log");
		this.productLogMqSender.send("test product log");
		this.orderLogMqSender.send("test order log");
		Thread.sleep(1000);
	}


}
