package com.sehyeonn.community.dto;

public class Comment {
	int id;				// NOT NULL
	String userId;		// Default : Unknown user
	int postId;			// NOT NULL
	String content;		// NOT NULL
	String postedDatetime;	// NOT NULL
	
	String username;
	String postTitle;

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

	public String getPostedDatetime() {
		return postedDatetime;
	}

	public void setPostedDatetime(String postedDatetime) {
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
