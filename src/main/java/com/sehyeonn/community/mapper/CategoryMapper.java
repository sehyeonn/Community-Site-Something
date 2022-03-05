package com.sehyeonn.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sehyeonn.community.dto.Category;

@Mapper
public interface CategoryMapper {
	
	// 전체 카테고리 조회
	@Select("SELECT * FROM category")
	List<Category> findAll();
	
	// 해당 아이디의 카테고리 조회
	@Select("SELECT * FROM category WHERE id=#{id}")
	Category findById(int id);
	
}
