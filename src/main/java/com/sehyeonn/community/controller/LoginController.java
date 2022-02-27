package com.sehyeonn.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sehyeonn.community.dto.User;
import com.sehyeonn.community.mapper.UserMapper;

@Controller
public class LoginController {
	
	@Autowired UserMapper userMapper;
	
	@GetMapping("login/login")
	public String login(Model model) {
		return "login/login";
	}
	
	@PostMapping("login/login")
	public String login(Model model, String userId, String password) {
		String errorMsg = "";
		User user = userMapper.findPassword(userId);
		
		if(userId == null || userId.length() == 0) {
			errorMsg = "Enter your ID";
		} else if(password == null || password.length() == 0) {
			errorMsg = "Enter your PASSWORD";
		} else if(user == null) {
			errorMsg = "The ID doesn\'t exist";
		} else if(user.getPassword().equals(password) == false) {
			errorMsg = "The password doesn\'t match";
		} else {
			return "redirect:/test/index";	// 임시로 설정해 놓은 뷰, 메인페이지가 생기면 바꿀 것
		}
		model.addAttribute("errorMsg", errorMsg);
		return "login/login";
	}
}
