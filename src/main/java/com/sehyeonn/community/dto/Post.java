package com.sehyeonn.community.dto;

import java.util.Date;

public class Post {
	int id;				// NOT NULL
	String userId;		// Default : Unknown user
	int categoryId;		// Null able
	String title;		// NOT NULL
	String content;		// NOT NULL
	Date postedDatetime;		// NOT NULL
	Date updatedDatetime;		// Null able
	int hits;		// Default : 0
	
	String username;

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}

	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
