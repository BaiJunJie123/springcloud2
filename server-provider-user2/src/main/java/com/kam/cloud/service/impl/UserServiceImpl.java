package com.kam.cloud.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kam.cloud.service.Userservice;
import com.kam.cloud.dao.UserDao;
import serverCloudApi.entitys.User;
@Service(value="UserServiceImpl")
public class UserServiceImpl implements Userservice {
	@Resource
	private UserDao  UserDao;
	@Override
	public List<User> findList() {
		// TODO Auto-generated method stub
		return UserDao.findList();
	}

}
