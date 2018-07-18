package com.cheung;

import com.cheung.mq.LogMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProducerApplication.class})
public class ProducerApplicationTests {

	@Autowired
	private LogMqSender logMqSender;

	@Test
	public void testSendMqForLog() throws InterruptedException {
		int i = 0;
		while (true) {
			this.logMqSender.sendMqForLog("test RabbitMQ-durable --> " + ++i);
			Thread.sleep(1000);
		}
	}

}
