package com.kam.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.UpperCamelCaseStrategy;
import com.kam.cloud.service.*;
import com.kam.cloud.service.impl.UserServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import serverCloudApi.entitys.User;
@RestController
public class UserControler {
	@Resource(name="UserServiceImpl")
	private Userservice Userservice;
	@Autowired
	private DiscoveryClient client; //eureka服务发现
	@RequestMapping(value ="/findList",method=RequestMethod.GET)
	//@HystrixCommand(fallbackMethod="fallbackuser")
	public Object findList() {
		if(true) {
			throw new RuntimeException("异常");
		}
		Userservice.findList();
		return Userservice.findList();
	}
	
	public Object fallbackuser() {
		List<User> ji = new ArrayList<User>();
		User uu = new User();
		uu.setDbSource("没有信息");
		uu.setName("没有信息");
		uu.setPass("没有信息");
		ji.add(uu);
		return ji;
	}
	/*
	 * public User findUser(("id") int id) {
	 * 
	 * return new User(); }
	 */
	
	@RequestMapping(value="/user/discovery")
	public Object getDiscoveryClient() {
		List<String> listji = client.getServices();
		System.out.println("*************"+listji);
		List<ServiceInstance> srvlist = client.getInstances("SERVER-PROVIDER-USER"); //server-provider-user
		for(ServiceInstance s : srvlist) {
			System.out.println(s.getHost()+"---"+s.getPort()+"---"+s.getServiceId()+"---"+s.getUri());
		}
		return this.client;
	}
}
