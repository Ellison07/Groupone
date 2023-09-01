package com.example.groupone.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.groupone.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long>{

}
