package com.cheung.controller;

import com.cheung.model.material;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 测试 controller
 *
 * @author Cheung
 */
@RestController
@RequestMapping("/cache")
public class TestCacheController {

	/**
	 * @Cacheable 注解
	 * -cacheNames：当系统中有多个缓存时，指定该方法使用其中的哪几个缓存。
	 * -key：缓存的key，可以使用spEL表达式，例子中，使用了入参name。
	 * -sync ：true或false，当并发量非常大时，将同步开启，可以保证只有一个线程执行方法，其他线程将等待，然后从缓存中读取数据。
	 * -condition：使用缓存的条件。
	 * -keyGenerator：指定key的生成器。
	 *
	 * @param name
	 * @return
	 * @throws InterruptedException
	 */
	@Cacheable(cacheNames = "mycache", key = "#name", sync = false)
	@RequestMapping("test")
	public material test(String name) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("模拟业务处理，耗时：5s");
		material material = new material();
		material.setId(1);
		material.setName(name);
		material.setQuality(new BigDecimal("10001"));
		material.setDesc("这是测试商品");
		return material;
	}

}
