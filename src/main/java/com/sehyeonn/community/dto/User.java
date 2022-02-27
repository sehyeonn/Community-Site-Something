package com.sehyeonn.community.dto;

public class User {
	String id;			// NOT NULL
	String password;	// NOT NULL
	String username;	// NOT NULL
	String signupDate;	// NOT NULL
	String resentVisitDate;		// NOT NULL

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}

	public String getResentVisitDate() {
		return resentVisitDate;
	}

	public void setResentVisitDate(String resentVisitDate) {
		this.resentVisitDate = resentVisitDate;
	}
}
