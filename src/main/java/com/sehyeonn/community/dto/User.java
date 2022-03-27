package com.sehyeonn.community.dto;

import java.util.Date;

public class User {
	private String id;			// NOT NULL
	private String password;	// NOT NULL
	private String salt;		// NOT NULL
	private String username;	// NOT NULL
	private Date signupDate;	// NOT NULL

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

}
