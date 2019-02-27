package com.ssm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.domain.User;
import com.ssm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addUser")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/index";
	}

	/**
	 * 查询用户列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String getUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("userlist", users);
		return "index";
	}
	/**
	 * 获取修改用户
	 * @param model
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/findUserById")
	public String getUser(Model model,Integer uid) {
		User user = userService.getUser(uid);
		model.addAttribute("user", user);
		return "edit";
	}
	
	/**
	 * 修改User
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/updateUser")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:/index";
	}
	
	/**
	 * 删除User
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/deleteUser")
	public String deleteUser(Integer uid) {
		userService.deleteUser(uid);
		return "redirect:/index";
	}

}
