package com.sehyeonn.community.utility;

import java.security.MessageDigest;
import java.security.SecureRandom;

// 회원가입, 로그인 시 salt 값 생성, 비밀번호 해싱, 비교를 위한 클래스
public class Crypto {
	
	private static final int SALT_SIZE = 10;	// salt값의 크기
	
	// salt값 생성
	public static String createSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[SALT_SIZE];
		random.nextBytes(salt);
		
		return byteToString(salt);
	}
	
	// 비밀번호를 salt값과 함께 해싱하여 리턴
	public static String hashing(String password, String salt) throws Exception {
			return doHashing(password, salt);
	}
	private static String doHashing(String password, String salt) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		
		// key stretching
		for(int i=0; i<1000; i++) {
			String temp = password + salt;		// 비밀번호와 salt를 합친 문자열 생성
			md.update(temp.getBytes());			// 문자열 해싱
			password = byteToString(md.digest());	// 다이제스트를 얻어 password 갱신
		}
		
		return password;	// 해싱 완료된 비밀번호 반환
	}
	
	// 바이트 배열을 문자열로 변환하는 메소드
	private static String byteToString(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for(byte a : temp) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
	}
	
}
