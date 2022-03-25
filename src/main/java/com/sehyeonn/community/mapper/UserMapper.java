package com.sehyeonn.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sehyeonn.community.dto.User;

@Mapper
public interface UserMapper {
	
	// 모든 유저 정보 조회
	@Select("SELECT * FROM user")
	List<User> findAll();
	
	// 유저 아이디로 유저 정보 조회
	@Select("SELECT * FROM user WHERE id=#{id}")
	User findById(String id);
	
	@Insert("INSERT user (id, password, salt, username, signupDate)" +
			"VALUES (#{id}, #{password}, #{salt}, #{username}, #{signupDate})")
	void insert(User user);
	
}
