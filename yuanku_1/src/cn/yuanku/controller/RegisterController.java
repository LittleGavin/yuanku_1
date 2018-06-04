package cn.yuanku.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yuanku.po.User;
import cn.yuanku.po.UserQueryVo;
import cn.yuanku.service.UserService;

@Controller
public class RegisterController {
	
	@Resource 
	private UserService userService; 
	
	@RequestMapping(value = "/toRegister.action")
	public String toRegister() {
		return "Register";
	}

	@RequestMapping("/register")
	public String register(String telephone, String password ,Model model) throws Exception{
		
		//判断手机号是否已经注册，手机号是否正确，新手机号则插入新用户，返回注册成功页面
		
		User users =  userService.findUserByTelephone(telephone);
		if(users != null){
			throw new IllegalStateException("手机号已注册，请重新输入！");
		}else if (telephone.length() != 11){
			throw new IllegalStateException("您输入的手机号有误，请重新输入!");
		}else{
			User user = new User();
			user.setTelephone(telephone);
			user.setPassword(password);
			userService.insertUser(user);
			
		    //注册成功页面上需要有登录入口，或注册成功后可直接进入登录后页面
			return "register_success";
		}
	}
}
