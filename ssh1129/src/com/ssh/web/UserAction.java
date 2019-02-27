package com.ssh.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.domain.User;
import com.ssh.service.UserService;

public class UserAction extends ActionSupport {

	/* UserService层 */
	private UserService userService;
	@Override
	public String execute() throws Exception {

		//User user = userService.getUser(2);
	    User user2 = userService.getUser2();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user2);
		return "success";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


}
