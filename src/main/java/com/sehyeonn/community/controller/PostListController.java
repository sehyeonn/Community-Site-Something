package com.sehyeonn.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sehyeonn.community.mapper.PostMapper;

@Controller
public class PostListController {
	
	@Autowired PostMapper postMapper;
	
	@GetMapping("main/postList")
	public String postList(Model model, String searchText) {
		if(searchText == null) searchText = "";
		model.addAttribute("posts", postMapper.findListBySearchText("%"+searchText+"%", 0, 30));
		model.addAttribute("searchText", searchText);
		return "main/postList";
	}

}
