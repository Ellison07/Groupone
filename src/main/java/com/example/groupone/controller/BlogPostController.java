package com.example.groupone.controller;

import com.example.groupone.dto.BlogPostDTO;
import com.example.groupone.exception.ResourceNotFoundException;
import com.example.groupone.mapper.BlogPostMapper;
import com.example.groupone.model.BlogPost;
import com.example.groupone.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    private final BlogPostService blogPostService;
    private final BlogPostMapper blogPostMapper;

    @Autowired
    public BlogPostController(BlogPostService blogPostService, BlogPostMapper blogPostMapper) {
        this.blogPostService = blogPostService;
        this.blogPostMapper = blogPostMapper;
    }

    @PostMapping
    public BlogPostDTO createBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
        BlogPost blogPost = blogPostMapper.toEntity(blogPostDTO);
        BlogPost createdBlogPost = blogPostService.createBlogPost(blogPost);
        return blogPostMapper.toDto(createdBlogPost);
    }

    @GetMapping
    public List<BlogPostDTO> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return blogPosts.stream()
                .map(blogPostMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BlogPostDTO getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.getBlogPostById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog post not found with id: " + id));
        return blogPostMapper.toDto(blogPost);
    }

    @PutMapping("/{id}")
    public BlogPostDTO updateBlogPost(@PathVariable Long id, @RequestBody BlogPostDTO updatedBlogPostDTO) {
        BlogPost updatedBlogPost = blogPostMapper.toEntity(updatedBlogPostDTO);
        BlogPost updatedEntity = blogPostService.updateBlogPost(id, updatedBlogPost);
        return blogPostMapper.toDto(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
    }
}
