package com.cheung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者的启动类
 *
 * @EnableEurekaClient 表示当前为eureka-client端
 * @author Cheung
 */
@EnableEurekaClient
@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}
