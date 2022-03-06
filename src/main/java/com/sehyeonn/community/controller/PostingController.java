package com.sehyeonn.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sehyeonn.community.dto.Post;
import com.sehyeonn.community.mapper.CategoryMapper;
import com.sehyeonn.community.mapper.PostMapper;

@Controller
public class PostingController {
	
	@Autowired PostMapper postMapper;
	@Autowired CategoryMapper categoryMapper;
	
	@GetMapping("main/posting")
	public String posting(Model model, Integer categoryId) {
		if(categoryId == null) {
			//model.addAttribute("category", "All");
		} else {
			model.addAttribute("selectedCategory", categoryId);
		}
		Post newPost = new Post();
		model.addAttribute("newPost", newPost);
		model.addAttribute("categories", categoryMapper.findAll());
		return "main/posting";
	}
	
	@PostMapping("main/posting")
	public String posting(Model model, Post post) {
		return "main/posting";
	}
	
}
