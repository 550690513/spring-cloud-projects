package com.cheung;

import com.cheung.mq.LogSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProducerApplication.class})
public class ProducerApplicationTests {

	@Autowired
	private LogSender logSender;

	@Test
	public void testSendInfoLog() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			this.logSender.sendInfoLog("test info log --> " + i);
			Thread.sleep(1000);
		}
	}

	@Test
	public void testSendErrorLog() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			this.logSender.sendErrorLog("test error log --> " + i);
			Thread.sleep(1000);
		}
	}

}
