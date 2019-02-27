package com.ssm.dao;

import java.util.List;

import com.ssm.domain.User;

public interface UserMapper {

	/* 添加用户 */
	public void addUser(User user);
	
	/* 查询用户列表 */
    public List<User> getUsers();
    
    /* 查询用户 */
    public User getUser(Integer uid);
    
    /* 修改User */
    public void updateUser(User user);
    
    /* 删除用户 */
    public void deleteUser(Integer uid);
    
}
