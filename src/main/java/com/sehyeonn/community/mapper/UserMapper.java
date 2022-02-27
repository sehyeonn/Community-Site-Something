package com.sehyeonn.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sehyeonn.community.dto.User;

@Mapper
public interface UserMapper {
	
	// 모든 유저 정보 조회
	@Select("SELECT * FROM user")
	List<User> findAll();
	
	// 로그인 시 저장된 유저의 비밀번호 비교를 위한 메소드
	@Select("SELECT password FROM user WHERE id=#{id}")
	User findPassword(String id);
	
}
