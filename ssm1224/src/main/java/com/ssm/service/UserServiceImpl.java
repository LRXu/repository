package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserMapper;
import com.ssm.domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	
	/**
	 * 添加用户
	 */
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	/**
	 * 获取用户列表
	 */
	@Override
	public List<User> getUsers() {
		List<User> users = userMapper.getUsers();
		return users;
	}

	/**
	 * 获取单个用户
	 */
	@Override
	public User getUser(Integer uid) {
		
		User user = userMapper.getUser(uid);
		return user;
	}

	/**
	 * 修改User
	 */
	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}
	
	/**
	 * 删除User
	 */
	@Override
	public void deleteUser(Integer uid) {
		userMapper.deleteUser(uid);
	}
}
