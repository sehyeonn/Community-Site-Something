package com.sehyeonn.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sehyeonn.community.dto.Post;

@Mapper
public interface PostMapper {
	
	// 게시글 목록 offset부터 rowCount개 조회 (최신순 정렬)
	@Select("SELECT post.id, title, categoryId, postedDatetime, hits, username " +
			"FROM post JOIN user ON post.userId=user.id " +
			"ORDER BY post.id DESC" +
			"LIMIT #{offset}, #{rowCount}")
	List<Post> findList(int offset, int rowCount);
	
	// 해당 카테고리의 게시글 목록 offset부터 rowCount개 조회 (최신순 정렬)
	@Select("SELECT post.id, title, categoryId, postedDatetime, hits, username " +
			"FROM post JOIN user ON post.userId=user.id " +
			"WHERE categoryId=#{categoryId} " +
			"ORDER BY post.id DESC"+
			"LIMIT #{offset}, #{rowCount}")
	List<Post> findListByCategory(int categoryId, int offset, int rowCount);

}
