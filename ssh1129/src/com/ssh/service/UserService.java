package com.ssh.service;

import com.ssh.dao.UserDao;
import com.ssh.domain.User;

public class UserService {

	/**
	 * dao层数据库操作
	 */
	private UserDao uDao;

	public User getUser(int id) {
		return uDao.getUser(id);
	}
	
	public User getUser2() {
		return uDao.getUser2();
	}
	
	public void addUser(User user) {
		uDao.addUser(user);
	}
	

	public UserDao getuDao() {
		return uDao;
	}

	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}

}
