package com.example.groupone.model;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="Blogpost")
public class BlogPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
    private Long id;
	
	@Column(name="title")
    private String title;
	
	@Column(name="content")
    private String content;
	
	@Column(name="publicationdate")
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


public BlogPost(Long id, String title, String content, Date publicationDate) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.publicationDate = publicationDate;
}

@Override
public String toString() {
	return "BlogPost [id=" + id + ", title=" + title + ", content=" + content + ", publicationDate=" + publicationDate
			+ "]";
}

public BlogPost() {
	super();
}

}
