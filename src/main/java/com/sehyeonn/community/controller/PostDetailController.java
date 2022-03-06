package com.sehyeonn.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sehyeonn.community.dto.Comment;
import com.sehyeonn.community.mapper.CommentMapper;
import com.sehyeonn.community.mapper.PostMapper;

@Controller
public class PostDetailController {
	
	@Autowired PostMapper postMapper;
	@Autowired CommentMapper commentMapper;
	
	@GetMapping("main/postDetail")
	public String postList(Model model, Integer postId) {
		if(postId == null) // 잘못된 접근 뭔가 추가하기
			return "redirect:postList";
		
		model.addAttribute("post", postMapper.findById(postId));
		model.addAttribute("numberOfComments", commentMapper.countCommentByPostID(postId));
		model.addAttribute("comments", commentMapper.findAllCommentsByPostId(postId));
		
		Comment newComment = new Comment();
		model.addAttribute("newComment", newComment);
		
		return "main/postDetail";
	}

}