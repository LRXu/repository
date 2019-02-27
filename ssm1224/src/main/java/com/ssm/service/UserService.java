package com.ssm.service;

import java.util.List;

import com.ssm.domain.User;

public interface UserService {
	
	/* 添加 */
	public void addUser(User user);
	/* 查询列表 */
	public List<User> getUsers();
	/* 查询单个 */
	public User getUser(Integer uid);
	/* 修改User */
	public void updateUser(User user);
	/* 删除User */
	public void deleteUser(Integer uid);

}
