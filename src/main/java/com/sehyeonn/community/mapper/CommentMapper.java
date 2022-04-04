package com.sehyeonn.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.sehyeonn.community.dto.Comment;

@Mapper
public interface CommentMapper {
	
	// 해당 게시글의 댓글 개수를 받환하는 메소드
	@Select("SELECT count(comment.id) FROM comment WHERE postId=#{postId}")
	int countCommentByPostID(int postId);
	
	// 햐당 게시글의 댓글들을 반환하는 메소드
	@Select("SELECT comment.id, username, postId, content, DATE_FORMAT(postedDatetime, \'%Y-%m-%d\') AS postedDatetime " +
			"FROM comment JOIN user ON comment.userId=user.id " +
			"WHERE comment.postId=#{postId}")
	List<Comment> findAllCommentsByPostId(int postId);
	
	@Insert("INSERT comment (userId, postId, content, postedDatetime) " +
			"VALUE (#{userId}, #{postId}, #{content}, #{postedDatetime})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void insert(Comment comment);

}
