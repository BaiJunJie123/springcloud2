package com.kam.cloud.UserController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
	//private static final String URL_providerUser="http://localhost:8001";
	private static final String URL_providerUser="http://SERVER-PROVIDER-USER";
	//@Autowired
	@Resource
	private RestTemplate restTemplate;
	@RequestMapping("/getlist")
	public Object getList() {
		
		return restTemplate.getForObject(URL_providerUser+"/findList", List.class);
	}
	@RequestMapping("/fuwufaxian")
	public Object getfu() {
		return restTemplate.getForObject(URL_providerUser+"/user/discovery", Object.class);
	}
}
