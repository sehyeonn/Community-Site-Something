package com.sehyeonn.community.dto;

import java.util.Date;

public class Comment {
	private int id;				// NOT NULL
	private String userId;		// Default : Unknown user
	private int postId;			// NOT NULL
	private String content;		// NOT NULL
	private Date postedDatetime;	// NOT NULL
	
	private String username;
	private String postTitle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostedDatetime() {
		return postedDatetime;
	}

	public void setPostedDatetime(Date postedDatetime) {
		this.postedDatetime = postedDatetime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
}
