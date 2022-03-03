package com.sehyeonn.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sehyeonn.community.dto.Post;
import com.sehyeonn.community.mapper.PostMapper;

@Controller
public class PostListController {
	
	@Autowired PostMapper postMapper;
	
	@GetMapping("main/postList")	// 선택한 카테고리, 조회 중인 페이지 번호, 검색할 내용을 request parameter 로 받음
	public String postList(Model model, Integer categoryId, Integer pageNumber, String searchText) {
		if(pageNumber == null) pageNumber = 1;	// 처음엔 1페이지부터 조회
		if(searchText == null) searchText = "";
		
		List<Post> postList;
		
		if(categoryId == null) {	// 처음엔 전체 게시물 목록부터 보여줌
			postList = postMapper.findList("%"+searchText+"%", (pageNumber-1)*30, 30);
			model.addAttribute("posts", postList);
		} else {	// 이후 카테고리 선택 시 해당 카테고리의 게시글 목록을 보여줌
			postList = postMapper.findListByCategory(categoryId, "%"+searchText+"%", (pageNumber-1)*30, 30);
			model.addAttribute("posts", postList);
		}
		
		model.addAttribute("categories", postMapper.findAllCategory());
		model.addAttribute("searchText", searchText);
		model.addAttribute("pageNumber", pageNumber);
		
		return "main/postList";
	}

}
