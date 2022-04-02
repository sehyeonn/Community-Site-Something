package com.sehyeonn.community.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sehyeonn.community.dto.Comment;
import com.sehyeonn.community.dto.Post;
import com.sehyeonn.community.dto.User;
import com.sehyeonn.community.mapper.CategoryMapper;
import com.sehyeonn.community.mapper.CommentMapper;
import com.sehyeonn.community.mapper.PostMapper;
import com.sehyeonn.community.utility.PageMaker;

@Controller
public class PostController {
	
	@Autowired PostMapper postMapper;
	@Autowired CategoryMapper categoryMapper;
	@Autowired CommentMapper commentMapper;
	
	final int POST_PER_PAGE = 10;
	
	// 게시글 목록 페이지 표시
	@RequestMapping("main/postList")	// 선택한 카테고리, 조회 중인 페이지 번호, 검색할 내용을 request parameter 로 받음
	public String postList(Model model, Integer categoryId, Integer pageNumber, String searchText) {
		if(pageNumber == null || pageNumber < 1) pageNumber = 1;	// 처음엔 1페이지부터 조회
		if(searchText == null) searchText = "";
		
		List<Post> postList;
		int countPost;	// 게시글 총 개수
		
		if(categoryId == null) {	// 처음엔 전체 게시물 목록부터 보여줌
			postList = postMapper.findList("%"+searchText+"%", (pageNumber-1)*POST_PER_PAGE, POST_PER_PAGE);
			countPost = postMapper.countPost();
		} else {	// 이후 카테고리 선택 시 해당 카테고리의 게시글 목록을 보여줌
			postList = postMapper.findListByCategory(categoryId, "%"+searchText+"%", (pageNumber-1)*POST_PER_PAGE, POST_PER_PAGE);
			countPost = postMapper.countPostByCategory(categoryId);
		}
		
		model.addAttribute("pageMaker", new PageMaker(pageNumber, POST_PER_PAGE, countPost));
		model.addAttribute("posts", postList);
		model.addAttribute("categories", categoryMapper.findAll());
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("searchText", searchText);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("countPost", countPost);
		
		return "main/postList";
	}
	
	// 게시글 상세 페이지 표시
	@GetMapping("main/postDetail")
	public String postDetail(Model model, Integer postId) {
		if(postId == null) // 잘못된 접근 뭔가 추가하기
			return "redirect:postList";
		
		model.addAttribute("post", postMapper.findById(postId));
		model.addAttribute("numberOfComments", commentMapper.countCommentByPostID(postId));
		model.addAttribute("comments", commentMapper.findAllCommentsByPostId(postId));
		
		Comment newComment = new Comment();
		model.addAttribute("newComment", newComment);
		
		return "main/postDetail";
	}
	
	// 게시글 등록(작성) 페이지 표시
	@GetMapping("main/posting")
	public String posting(Model model, Integer categoryId) {
		if(categoryId == null) {
			//model.addAttribute("category", "All");
		} else {
			model.addAttribute("selectedCategory", categoryId);
		}
		model.addAttribute("categories", categoryMapper.findAll());
		return "main/posting";
	}
	
	// 게시글 DB에 등록
	@PostMapping("main/posting")
	public String posting(Model model, Integer categoryId, String title, String content, HttpSession session) {
		String userId = ((User)session.getAttribute("user")).getId();
		
		// 새로운 게시글 생성
		Post newPost = new Post();
		if(categoryId != null)
			newPost.setCategoryId(categoryId);
		newPost.setTitle(title);
		newPost.setContent(content);
		newPost.setUserId(userId);	// session에서 현재 로그인 중인 유저 정보를 가져와 작성자로 설정
		newPost.setPostedDatetime(new Date());
		
		postMapper.insert(newPost);	// DB에 게시글 등록
		System.out.println(userId + " 게시글 DB 등록 완료");
		
		if(categoryId == null)
			return "redirect:postList?categoryId=";
		else
			return "redirect:postList?categoryId=" + categoryId;
	}

}
