package com.example.groupone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.groupone.dto.BlogPostDTO;
import com.example.groupone.mapper.BlogPostMapper;
import com.example.groupone.model.BlogPost;
import com.example.groupone.repository.BlogPostRepository;
import com.example.groupone.services.serviceImpl.BlogPostServiceImpl;
import java.sql.Date;
@ImportResource("classpath:test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest
class GrouponeApplicationTests {

	@Autowired
	private BlogPostServiceImpl service;
	
	@MockBean
	private BlogPostRepository repository;
	
	
    @Test
	public void getAllBlogPostTest() {
	    Date date1 = Date.valueOf("2023-09-17");
	    Date date2 = Date.valueOf("2023-09-17");

	    when(repository.findAll()).thenReturn(Stream.of(
	        new BlogPost(13L, "The power of Lies", "All is well", date1),
	        new BlogPost(14L, "The power of Lies", "All is well", date2)
	    ).collect(Collectors.toList()));
	    assertEquals(2,service.getAllBlogPosts().size());
	}
    @Test
    public void getBlogPostByIdTest(){
    	Long id = 14L;
	    Date date = Date.valueOf("2023-09-17");
	    
    	when(repository.findById(id)).thenReturn(Optional.of(
    	        new BlogPost(14L, "The power of Lies", "All is well", date)
    	    ));
    	Optional<BlogPost> result = service.getBlogPostById(id);
    	    assertTrue(result.isPresent());
    	assertEquals("The power of Lies", result.get().getTitle());
    }
    @Test
    public void createBlogPostTest(){
    	Long id = 1L;
	    Date date = Date.valueOf("2023-09-17");
    	BlogPost newBlogPost = new BlogPost(id,"New Blog Post","Content of the new blog post",date);
    	
    	when(repository.save(newBlogPost)).thenReturn(newBlogPost);
    	assertEquals(newBlogPost, service.createBlogPost(newBlogPost));
    }
    @Test
    public void deleteBlogPostByIdTest(){
    	Long id = 1L;
	    Date date = Date.valueOf("2023-09-17");
    	BlogPost newBlogPost = new BlogPost(id,"New Blog Post","Content of the new blog post",date);
    	service.deleteBlogPost(id);
    	verify(repository, times(1)).deleteById(newBlogPost.getId());
    }
    @Test
    public void updateBlogPostByIdTest() {
        Long id = 1L;
        Date date = Date.valueOf("2023-09-17");
        BlogPost existingBlogPost = new BlogPost(id, "Existing Blog Post", "Content of the existing blog post", date);
        when(repository.findById(id)).thenReturn(Optional.of(existingBlogPost));
        existingBlogPost.setTitle("Updated Blog Post");
        existingBlogPost.setContent("Updated content of the blog post");
        when(repository.save(existingBlogPost)).thenReturn(existingBlogPost);
        BlogPost updatedBlogPost = service.updateBlogPost(id, existingBlogPost);
        assertEquals(existingBlogPost, updatedBlogPost);
    }

	@Test
	void contextLoads() {
	}

}
