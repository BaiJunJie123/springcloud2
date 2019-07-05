package com.kam.cloud.UserController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import  serverCloudApi.service.*;
@RestController
public class UserController {
	@Autowired
	private UserClientService userClientService;
	
	@RequestMapping("/getlist")
	public Object getList() {
		return userClientService.getList();
	}
	
	@RequestMapping("/user/discovery")
	public Object getfu() {
		return userClientService.getfu();
		
	}
}
