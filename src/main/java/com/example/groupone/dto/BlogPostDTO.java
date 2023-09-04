package com.example.groupone.dto;

import java.util.Date;

    public class BlogPostDTO {
	   private Long id;
	   private String title;
	   private String content;
	   private Date publicationDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public BlogPostDTO(Long id, String title, String content, Date publicationDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.publicationDate = publicationDate;
	}
	public BlogPostDTO() {
		super();
	}
	@Override
	public String toString() {
		return "BlogPostDTO [id=" + id + ", title=" + title + ", content=" + content + ", publicationDate="
				+ publicationDate + "]";
	}
	   
}
