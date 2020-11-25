package com.watero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.watero.entity.User;
import com.watero.entity.UserExample;
import com.watero.entity.UserExample.Criteria;
import com.watero.exception.LoginFailedException;
import com.watero.mapper.UserMapper;
import com.watero.service.AdminService;
import com.watero.util.CommonConfigConstant;

import cn.hutool.crypto.SecureUtil;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User queryUserByAcctId(String loginAcct, String userPswd) {

		if (StringUtils.isEmpty(loginAcct)) {
			throw new LoginFailedException(CommonConfigConstant.MESSAGE_LOGIN_FAILED1);
		}
		if (StringUtils.isEmpty(userPswd)) {
			throw new LoginFailedException(CommonConfigConstant.MESSAGE_LOGIN_FAILED2);
		}
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAcctIdEqualTo(loginAcct);
		List<User> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			throw new LoginFailedException(CommonConfigConstant.MESSAGE_LOGIN_FAILED3);
		}
		if (!SecureUtil.md5(userPswd).equals(list.get(0).getPassword())) {
			throw new LoginFailedException(CommonConfigConstant.MESSAGE_LOGIN_FAILED4);
		}
		return list.get(0);
	}

	@Override
	public PageInfo<User> getUserListPageInfo(User user ,int pageNum,int pageSize) {
		// 开启分页
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = userMapper.getUserListPageInfo(user);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
