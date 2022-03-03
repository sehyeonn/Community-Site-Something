package com.sehyeonn.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sehyeonn.community.dto.Category;
import com.sehyeonn.community.dto.Post;

@Mapper
public interface PostMapper {

	// 게시글 목록 offset부터 rowCount개 조회, 검색할 내용이 있다면 제목이나 내용에 searchText가 포함되어 있는 게시글 목록을 반환 (최신순 정렬)
	@Select("SELECT post.id, title, categoryId, DATE_FORMAT(postedDatetime, \'%Y-%m-%d\') AS postedDatetime, hits, username " +
			"FROM post JOIN user ON post.userId=user.id " +
			"WHERE title LIKE #{searchText} OR content LIKE #{searchText} " +
			"ORDER BY post.id DESC " +
			"LIMIT #{offset}, #{rowCount}")
	List<Post> findList(String searchText, int offset, int rowCount);
	
	// 해당 카테고리의 게시글 목록 offset부터 rowCount개 조회, 검색할 내용이 있다면 제목이나 내용에 searchText가 포함되어 있는 게시글 목록을 반환 (최신순 정렬)
	@Select("SELECT post.id, title, categoryId, DATE_FORMAT(postedDatetime, \'%Y-%m-%d\') AS postedDatetime, hits, username " +
			"FROM post JOIN user ON post.userId=user.id " +
			"WHERE categoryId=#{categoryId} AND (title LIKE #{searchText} OR content LIKE #{searchText}) " +
			"ORDER BY post.id DESC "+
			"LIMIT #{offset}, #{rowCount}")
	List<Post> findListByCategory(int categoryId, String searchText, int offset, int rowCount);
	
	// 게시글 아이디로 게시글 하나 조회하는 메소드
	@Select("SELECT post.id, title, username, content, username, categoryId, DATE_FORMAT(postedDatetime, \'%Y-%m-%d %H:%i\') AS postedDatetime, DATE_FORMAT(updatedDatetime, \'%Y-%m-%d %H:%i\') AS updatedDatetime " +
			"FROM post JOIN user ON post.userId=user.id " +
			"WHERE post.id=#{postId}")
	Post findById(int postId);
	
	
	// 전체 카테고리 조회
	@Select("SELECT * FROM category")
	List<Category> findAllCategory();

}
