package com.watero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watero.entity.User;
import com.watero.entity.UserExample;
import com.watero.mapper.UserMapper;
import com.watero.service.UserServcie;

@Service
public class UserServiceImpl implements UserServcie {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> queryUserList() {
		return userMapper.selectByExample(new UserExample());
	}

}
