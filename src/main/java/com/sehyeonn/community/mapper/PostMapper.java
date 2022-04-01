package com.sehyeonn.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sehyeonn.community.dto.Post;

@Mapper
public interface PostMapper {

	// 게시글 목록 offset부터 rowCount개 조회, 검색할 내용이 있다면 제목이나 내용에 searchText가 포함되어 있는 게시글 목록을 반환 (최신순 정렬)
	@Select("SELECT post.id, title, categoryId, postedDatetime, hits, username " +
			"FROM post JOIN user ON post.userId=user.id " +
			"WHERE title LIKE #{searchText} OR content LIKE #{searchText} " +
			"ORDER BY post.id DESC " +
			"LIMIT #{offset}, #{rowCount}")
	List<Post> findList(String searchText, int offset, int rowCount);
	
	// 해당 카테고리의 게시글 목록 offset부터 rowCount개 조회, 검색할 내용이 있다면 제목이나 내용에 searchText가 포함되어 있는 게시글 목록을 반환 (최신순 정렬)
	@Select("SELECT post.id, title, categoryId, postedDatetime, hits, username " +
			"FROM post JOIN user ON post.userId=user.id " +
			"WHERE categoryId=#{categoryId} AND (title LIKE #{searchText} OR content LIKE #{searchText}) " +
			"ORDER BY post.id DESC "+
			"LIMIT #{offset}, #{rowCount}")
	List<Post> findListByCategory(int categoryId, String searchText, int offset, int rowCount);
	
	// 게시글 아이디로 게시글 하나 조회하는 메소드
	@Select("SELECT post.id, title, username, content, username, categoryId, postedDatetime, updatedDatetime " +
			"FROM post JOIN user ON post.userId=user.id " +
			"WHERE post.id=#{postId}")
	Post findById(int postId);
	
	// 게시글의 개수를 조회하는 메소드
	@Select("SELECT COUNT(*) FROM post")
	int countPost();
	
	// 해당 카테고리의 게시글의 개수를 조회하는 메소드
	@Select("SELECT COUNT(*) FROM post WHERE categoryId=#{categoryId}")
	int countPostByCategory(int categoryId);
	
	// 게시글 등록
	@Insert("INSERT post (userId, categoryId, title, content, postedDatetime) " +
			"VALUE (#{userId}, #{categoryId}, #{title}, #{content}, #{postedDatetime})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void insert(Post post);
	
	// 게시글 수정
	@Update("UPDATE post SET categoryId=#{categoryId}, title=#{title}, content=#{content}, updatedDatetime=#{updatedDatetime} " +
			"WHERE id=#{id}")
	void update(Post post);

}
