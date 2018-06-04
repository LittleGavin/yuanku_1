package cn.yuanku.test;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yuanku.dao.UserMapper;
import cn.yuanku.po.User;
import cn.yuanku.po.UserVo;
import cn.yuanku.service.UserService;

public class LoginTest {

	private ApplicationContext applicationContext;
	@Before
	public void setUp(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	}
	
	@Test
	public void logintest() throws Exception{
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		
		User user = userMapper.selectByPrimaryKey("18844188804");
		
		System.out.println(user.toString());
		System.out.println(user.getUsername());
	}
}
