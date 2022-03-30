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
import com.sehyeonn.community.utility.Crypto;

@Controller
public class UserController {
	
	@Autowired UserMapper userMapper;
	
	// 로그인 페이지
	@GetMapping("login/login")
	public String login(Model model) {
		return "login/login";
	}
	// 로그인
	@PostMapping("login/login")
	public String login(Model model, String userId, String password, HttpSession session) {
		String errorMsg = "";
		User user = userMapper.findById(userId);
		
		if(user != null) {	// 입력받은 아이디의 유저가 존재한다면 입력 받은 비밀번호와 해당 유저의 salt와 함께 해싱
			try {
				password = Crypto.hashing(password, user.getSalt());
			} catch (Exception e) { e.printStackTrace();	}
		}
		
		if(userId == null || userId.length() == 0) {	// 아이디가 입력되지 않았을 때
			errorMsg = "Enter your ID";
		} else if(password == null || password.length() == 0) {		// 비밀번호가 입력되지 않았을 때
			errorMsg = "Enter your PASSWORD";
		} else if(user == null) {	// 입력 받은 아이디에 해당하는 유저가 존재하지 않을 때
			errorMsg = "The ID doesn\'t exist";
		} else if(user.getPassword().equals(password) == false) {	// 비밀번호가 일치하지 않을 때
			errorMsg = "The password doesn\'t match";
		} else {	// 로그인 성공
			session.setAttribute("user", user);	// 세션에 로그인한 유저 저장
			return "redirect:/main/postList";	// 임시로 설정해 놓은 뷰, 메인페이지가 생기면 바꿀 것
		}
		model.addAttribute(userId, userId);
		model.addAttribute("errorMsg", errorMsg);
		return "login/login";
	}
	// 회원가입 페이지
	@GetMapping("login/signup")
	public String signup(Model model) {
		return "login/signup";
	}
	// 회원 DB 등록
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
			
			String salt = Crypto.createSalt();	// 새로운 유저의 고유 salt값 생성
			newUser.setSalt(salt);
			try {
				newUser.setPassword(Crypto.hashing(password, salt));	// 비밀번호를 salt와 함께 해싱하여 데이터베이스에 저장
			} catch (Exception e) { e.printStackTrace(); }
			
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
	
	// 로그인 성공 페이지
	@RequestMapping("login/signupSuccessful")
	public String signupSuccessful(Model model) {
		return "login/signupSuccessful";
	}
}
