package com.kam.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.kam.my.MyseltRule;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient
//在该微服务启动的时候就自动加载我们的负载均衡配置类
@RibbonClient(name="SERVER-PROVIDER-USER", configuration=MyseltRule.class)
public class ConsumerUserApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserApp.class, args);
	}
}
