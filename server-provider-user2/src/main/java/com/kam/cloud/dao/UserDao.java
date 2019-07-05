package com.kam.cloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import serverCloudApi.entitys.User;
public interface UserDao{

	public List<User> findList();
}
