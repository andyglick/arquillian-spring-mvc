package com.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login(){
		return "redirect:pages/login.jsp";
	}

	@RequestMapping(value="pages/userCheck", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		if("test".equalsIgnoreCase(name)&&"test".equalsIgnoreCase(pwd)){
			model.addAttribute("message", "Successfully logged in.");
			
		}else{
			model.addAttribute("message", "Username or password is wrong.");
		}
		return "redirect:success.jsp";
	}
	
}