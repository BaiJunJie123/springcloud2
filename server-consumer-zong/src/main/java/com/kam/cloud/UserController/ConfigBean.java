package com.kam.cloud.UserController;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {
	public ConfigBean() {
		System.out.println("配置类加载了");
	}

	@Bean
	@LoadBalanced //负载均衡
	public RestTemplate restTemplate(ClientHttpRequestFactory Factory) {
		return  new RestTemplate(Factory);//builder.build();
	}
	/*
	 * @Bean public IRule myRule() {
	 * 
	 * //return new RandomRule(); //负载均衡改为随机算法 return new RetryRule(); }
	 */

	@Bean
	public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setReadTimeout(180000);// 单位为ms
		factory.setConnectTimeout(5000);// 单位为ms 
		return factory;
	}

}
