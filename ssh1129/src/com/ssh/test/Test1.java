package com.ssh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.dao.UserDao;
import com.ssh.domain.User;
import com.ssh.service.UserService;

public class Test1 {

	

	@Test
	public void fun1() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService uService = (UserService)aContext.getBean("userService");
		User user = new User();
		user.setName("chen234");
		uService.addUser(user);
	}

	@Test
	public void fun2() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService uService = (UserService)aContext.getBean("userService");
		User user = uService.getUser2();
		System.out.println(user.getName());
	}

}
