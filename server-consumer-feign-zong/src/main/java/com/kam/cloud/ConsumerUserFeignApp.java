package com.kam.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

//scanBasePackages= {"serverCloudApi.service"}
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages= {"serverCloudApi.service"})
@ComponentScan({"com.kam.cloud.UserController","serverCloudApi.service"})
public class ConsumerUserFeignApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserFeignApp.class, args);
	}
}
