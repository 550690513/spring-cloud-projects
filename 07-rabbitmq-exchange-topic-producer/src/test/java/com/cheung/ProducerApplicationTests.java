package com.cheung;

import com.cheung.mq.OrderLogSender;
import com.cheung.mq.ProductLogSender;
import com.cheung.mq.UserLogSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProducerApplication.class})
public class ProducerApplicationTests {

	@Autowired
	private UserLogSender userLogSender;

	@Autowired
	private ProductLogSender productLogSender;

	@Autowired
	private OrderLogSender orderLogSender;

	@Test
	public void testSend() throws InterruptedException {
		this.userLogSender.send("test user log");
		this.productLogSender.send("test product log");
		this.orderLogSender.send("test order log");
		Thread.sleep(1000);
	}


}
