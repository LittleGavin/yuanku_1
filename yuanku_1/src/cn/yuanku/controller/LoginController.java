package cn.yuanku.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/login")
	public String login() throws Exception{
		return "login";
	}
	
	public String submit(String username, String pwd, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		if(username != null){
			session.setAttribute("username", username);
		}
		
		return "redirect:";
	}
}
