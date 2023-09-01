package com.example.groupone.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.groupone.repository.BlogPostRepository;

public interface BlogPostServices extends  JpaRepository <BlogPostRepository, Long>{

}
