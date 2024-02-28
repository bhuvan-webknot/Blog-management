package com.example.blogmanagement.BlogManagement.dto;

import com.example.blogmanagement.BlogManagement.models.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;


@Getter
@Setter
@AllArgsConstructor
public class CustomResponse {
    private Blog message;
    private long timeTakenToServeTheRequest;
}