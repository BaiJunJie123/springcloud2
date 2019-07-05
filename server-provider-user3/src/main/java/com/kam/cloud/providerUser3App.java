package com.kam.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.kam.cloud.dao")
@EnableEurekaClient //启动后会自动注册进eureka server服务中
@EnableDiscoveryClient //EUREKA 服务发现
public class providerUser3App {

	public static void main(String[] args) {
		SpringApplication.run(providerUser3App.class, args);

	}
	/*
	 * dbcp2: min-idle: 5 initial-size: 5 max-total: 5 max-wait-millis: 200
	 */

}
