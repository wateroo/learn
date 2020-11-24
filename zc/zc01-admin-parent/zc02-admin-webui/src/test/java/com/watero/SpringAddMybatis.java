package com.watero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.watero.entity.User;
import com.watero.entity.UserExample;
import com.watero.mapper.UserMapper;
import com.watero.service.UserServcie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml",
		"classpath:spring/spring-service.xml" })
public class SpringAddMybatis {
	private Logger logger = LoggerFactory.getLogger(SpringAddMybatis.class);

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	UserServcie userService;

	@Test
	public void test() throws SQLException {
		System.out.println();
		System.out.println("数据源：" + dataSource.getClass());
		System.out.println();
		String sql = "select * from t_user";
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		statement.execute(sql);
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {

		}
	}

	@Test
	public void testMapper() {
		UserExample userExample = new UserExample();
		List<User> list = userMapper.selectByExample(userExample);
		logger.info("查询结果:  {} ", list);
		userExample.setOrderByClause("id desc");
		List<User> selectByExample = userMapper.selectByExample(userExample);
		logger.info(selectByExample.toString());
	}

	@Test
	public void testUserService() {
		List<User> list = userService.queryUserList();
		logger.info("查询结果:  {} ", list);
	}

}
