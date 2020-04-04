package com.steven.ssm.controller;

import com.steven.ssm.entity.User;
import com.steven.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/selectAll")
	@ResponseBody
	public List<User> selectAll(){
		return userService.selectAll();
	}

	@RequestMapping("/test")
	public String test(){
		return "user_list";
	}

	/**
	 * 测试事务
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("transactional/{id}/{name}")
	public int updateUsername(@PathVariable("id")String id, @PathVariable("name")String name) throws InterruptedException {
		return userService.updateUserName(id,name);
	}
}
