package com.example.blogmanagement.BlogManagement.dto;
import com.example.blogmanagement.BlogManagement.models.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class AllResponse {
    private List<Blog> message;
    private long timeTakenToServeTheRequest;
}