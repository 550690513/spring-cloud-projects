package com.cheung;

import com.cheung.mq.MqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class MqTests {

	@Autowired
	private MqSender mqSender;

	@Test
	public void testMqSendAndReceive() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			this.mqSender.send("Hello RabbitMQ --> " + i);
			Thread.sleep(1000);
		}
	}

}
