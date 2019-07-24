package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.UserModel;


@Mapper
public interface UserDao {
	void insertUser(UserModel userModel);
	UserModel getUserByLoginName(String loginName);
}
