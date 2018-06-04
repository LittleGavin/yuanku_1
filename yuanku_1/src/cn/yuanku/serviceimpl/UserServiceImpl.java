package cn.yuanku.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yuanku.dao.UserMapper;
import cn.yuanku.po.User;
import cn.yuanku.po.UserExample;
import cn.yuanku.po.UserExample.Criteria;
import cn.yuanku.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
	@Resource
	private UserMapper userMapper;
	
	//根据手机号查询用户
	@Override
	public User findUserByTelephone(String telephone) throws Exception {
		
		//创建UserExample对象
		UserExample userExample = new UserExample();
		
		Criteria createCreiteria = userExample.createCriteria();
		
		createCreiteria.andTelephoneEqualTo(telephone);
		
		User user = (User)userMapper.selectByExample(userExample);
		return user;
	}
	
	//插入用户
	@Override
	public void insertUser(User user) throws Exception {
		userMapper.insert(user);
	}
}
