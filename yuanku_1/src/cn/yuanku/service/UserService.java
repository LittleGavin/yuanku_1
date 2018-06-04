package cn.yuanku.service;

import java.util.List;

import cn.yuanku.po.User;
import cn.yuanku.po.UserQueryVo;
import cn.yuanku.po.UserVo;

public interface UserService {
	
	public User findUserByTelephone(String telephone) throws Exception;
	
	public void insertUser(User user) throws Exception;

}
