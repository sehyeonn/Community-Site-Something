package com.sehyeonn.community.dto;

public class Category {
	private int id;			// NOT NULL
	private String name;	// NOT NULL
	private String createdDate;		//NOT NULL

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", createdDate=" + createdDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
