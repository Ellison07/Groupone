package com.example.groupone.services;

import com.example.groupone.model.BlogPost;

import java.util.List;
import java.util.Optional;

public interface BlogPostService {

    BlogPost createBlogPost(BlogPost blogPost);

    List<BlogPost> getAllBlogPosts();

    Optional<BlogPost> getBlogPostById(Long id);

    BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost);

    void deleteBlogPost(Long id);
}
