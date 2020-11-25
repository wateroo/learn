package com.watero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.watero.entity.UserVO;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/hello/1")
	@ResponseBody
	public String hello1(String id,String userName,String createTime,@RequestParam(value = "password") String passWord) {
		return id;
	}

	@RequestMapping("/hello/user")
	@ResponseBody
	public UserVO helloUser(@RequestBody UserVO userVO) {
		return userVO;
	}

}
