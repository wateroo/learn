package com.watero.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.watero.entity.User;
import com.watero.service.AdminService;

import cn.hutool.crypto.SecureUtil;

@RequestMapping("/admin")
@Controller
public class AdminController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AdminService adminService;

	/**
	 * 登录
	 * 
	 * @param loginAcct
	 * @param userPswd
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
	public String login(@RequestParam(value = "loginAcct", required = true) String loginAcct,
			@RequestParam(value = "userPswd", required = true) String userPswd, HttpServletRequest request) {
		logger.info("loginAcct={},userPswd={}", loginAcct, userPswd);

		User user = adminService.queryUserByAcctId(loginAcct, userPswd);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		return "redirect:/main.html";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		logger.info("注销用户 ：{}", request.getSession().getAttribute("user"));
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
		return "redirect:/index.html";
	}

	@GetMapping("/user/list")
	public String userList(@RequestParam(required = false) User user,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model model) {
		PageInfo<User> userListPageInfo = adminService.getUserListPageInfo(user, pageNum, pageSize);
		model.addAttribute("pageInfo", userListPageInfo);
		return "";
	}

	@GetMapping(value = "/user/list1")
	@ResponseBody
	public PageInfo<User> userList1(User user,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model model) {
		PageInfo<User> userListPageInfo = adminService.getUserListPageInfo(user, pageNum, pageSize);
		return userListPageInfo;
	}

	public static void main(String[] args) {
		System.out.println(SecureUtil.md5("123"));
	}

}
