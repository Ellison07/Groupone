package com.example.groupone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.groupone.exception.ResourceNotFoundException;
import com.example.groupone.model.BlogPost;
import com.example.groupone.repository.BlogPostRepository;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {
   
   @Autowired
   private BlogPostRepository blogPostRepository;
   
   @PostMapping
   public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
	   return blogPostRepository.save(blogPost);
   }
   
   @GetMapping
   public List<BlogPost> getAllBlogPosts(){
	   return blogPostRepository.findAll();
   }
   
   @GetMapping("/{id}")
   public BlogPost getBlogPostById(@PathVariable Long id) {
       return blogPostRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Blog post not found with id: " + id));
   }
   @PutMapping("/{id}")
   public BlogPost updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
       BlogPost existingBlogPost = blogPostRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Blog post not found with id: " + id));
       
       existingBlogPost.setTitle(updatedBlogPost.getTitle());
       existingBlogPost.setContent(updatedBlogPost.getContent());

       return blogPostRepository.save(existingBlogPost);
   }

   @DeleteMapping("/{id}")
   public void deleteBlogPost(@PathVariable Long id) {
	   blogPostRepository.deleteById(id);
   }
   
}
