package com.cheung.service;

import com.cheung.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cheung
 */
@Service
public class UserService {

	/**
	 * ribbon的负载均衡器：通过该对象，可以获取到服务的ip、port等信息
	 * （Spring Cloud会根据spring.application.name来获取到指定名称的服务的相关信息，并封装到LoadBalancerClient对象当中）
	 */
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public List<User> getAll() {
		/*
		 * 1.根据服务名称，获取该服务的服务实例
		 */
		// ServiceInstance对象封装了指定服务的基本信息：如：ip、port
		ServiceInstance si = this.loadBalancerClient.choose("eureka-client-producer");

		/*
		 * 2.拼接所要访问服务的url
		 */
		StringBuffer url = new StringBuffer();
		// 直接访问的url：【http://localhost:8081/user】
		url.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/producer/user");

		/*
		 * 3.访问该url
		 */
		// 使用RestTemplate来发送请求：springMVC下的一个封装了基于rest模式的模板对象
		RestTemplate restTemplate = new RestTemplate();

		// 定义一个用来处理返回值类型的对象
		ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>() {
		};

		/*
		 * 发送请求
		 *
		 * 参数一：所要请求的url
		 * 参数二：请求方式
		 * 参数三：请求参数
		 * 参数四：返回值用什么类型来包装
		 * 返回值ResponseEntity：封装了返回值的信息
		 */
		ResponseEntity<List<User>> responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, null, type);

		List<User> list = responseEntity.getBody();

		return list;
	}

}
