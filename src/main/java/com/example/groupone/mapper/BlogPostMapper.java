package com.example.groupone.mapper;

import org.springframework.stereotype.Component;

import com.example.groupone.dto.BlogPostDTO;
import com.example.groupone.model.BlogPost;

@Component
public class BlogPostMapper {

    public BlogPostDTO toDto(BlogPost entity) {
        BlogPostDTO dto = new BlogPostDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setPublicationDate(entity.getPublicationDate());
        return dto;
    }

    public BlogPost toEntity(BlogPostDTO dto) {
        BlogPost entity = new BlogPost();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setPublicationDate(dto.getPublicationDate());
        return entity;
    }
}
