package com.sehyeonn.community.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sehyeonn.community.dto.User;
import com.sehyeonn.community.mapper.UserMapper;

@Controller
public class UserController {
	
	@Autowired UserMapper userMapper;
	
	@GetMapping("login/login")
	public String login(Model model) {
		return "login/login";
	}
	
	@PostMapping("login/login")
	public String login(Model model, String userId, String password, HttpSession session) {
		String errorMsg = "";
		User user = userMapper.findById(userId);
		
		if(userId == null || userId.length() == 0) {
			errorMsg = "Enter your ID";
		} else if(password == null || password.length() == 0) {
			errorMsg = "Enter your PASSWORD";
		} else if(user == null) {
			errorMsg = "The ID doesn\'t exist";
		} else if(user.getPassword().equals(password) == false) {
			errorMsg = "The password doesn\'t match";
		} else {
			session.setAttribute("user", user);	// 세션에 로그인한 유저 저장
			return "redirect:/main/postList";	// 임시로 설정해 놓은 뷰, 메인페이지가 생기면 바꿀 것
		}
		model.addAttribute(userId, userId);
		model.addAttribute("errorMsg", errorMsg);
		return "login/login";
	}
	
	@GetMapping("login/signup")
	public String signup(Model model) {
		return "login/signup";
	}
	
	@PostMapping("login/signup")
	public String signup(Model model, String userId, String password, String confirmPassword, String username) {
		String errorMsg = "";
		
		if(userId == null || userId.length() == 0) {
			errorMsg = "Enter your ID";
		} else if(password == null || password.length() == 0) {
			errorMsg = "Enter your PASSWORD";
		} else if(confirmPassword.equals(password) == false) {
			errorMsg = "The password doesn\'t match";
		} else {
			// 새로운 유저 생성 및 데이터베이스에 저장
			User newUser = new User();
			newUser.setId(userId);
			newUser.setPassword(password);
			newUser.setUsername(username);
			newUser.setSignupDate(new Date());
			userMapper.insert(newUser);
			
			return "redirect:signupSuccessful";	// 회원가입 성공 페이지로 이동
		}
		model.addAttribute(userId, userId);
		model.addAttribute(username, username);
		model.addAttribute("errorMsg", errorMsg);
		return "login/signup";
	}
	
	@RequestMapping("login/signupSuccessful")
	public String signupSuccessful(Model model) {
		return "login/signupSuccessful";
	}
}
