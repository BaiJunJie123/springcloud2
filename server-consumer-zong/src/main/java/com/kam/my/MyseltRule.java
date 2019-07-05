package com.kam.my;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MyseltRule {

	@Bean()
	public IRule myrule() {
		
		//return new RandomRule();
		return new Rule_ZY(); //自定义轮询
	}
}
