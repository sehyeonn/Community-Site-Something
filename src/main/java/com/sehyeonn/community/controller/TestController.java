package com.sehyeonn.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("test/index")
	public String index(Model model) {
		model.addAttribute("message", "Hello world");
		return "test/index";
	}
}