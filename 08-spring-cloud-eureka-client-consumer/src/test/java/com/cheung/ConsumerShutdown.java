package com.cheung;

import com.cheung.utils.HttpClientUtil;

/**
 * eureka-client-producer 优雅停服
 *
 * @author Cheung
 */
public class ConsumerShutdown {

	public static void main(String[] args) {
		// 向需要“优雅停服”的服务发送参数为“/shutdown”的url
		String url = "http://127.0.0.1:8082/shutdown";
		// 注意：该url必须要使用doPost方式来发送
		HttpClientUtil.doPost(url);
	}

}
