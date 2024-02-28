package com.example.blogmanagement.BlogManagement.controller;


import com.example.blogmanagement.BlogManagement.dto.AllResponse;
import com.example.blogmanagement.BlogManagement.exceptions.BlogNotFoundException;
import com.example.blogmanagement.BlogManagement.models.Blog;
import com.example.blogmanagement.BlogManagement.dto.CustomResponse;
import com.example.blogmanagement.BlogManagement.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping(value="/api/v1/")
public class BlogController {

    @Autowired
    BlogService blogService;

//    @ApiIgnore
//    @GetMapping(value="/")
//    public void redirect(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/swagger-ui.html");
//    }

    @PostMapping("/create-blog")
    public ResponseEntity<Blog>createBlog(@RequestBody Blog blog){
        Blog newBlog = blogService.createBlog(blog);
        return new ResponseEntity<>(newBlog,HttpStatus.OK);
    }


    @GetMapping("/list-blogs")
    public ResponseEntity<AllResponse>fetchAllBlogs(){
        Instant start = Instant.now();
        List<Blog>blogs  = blogService.fetchAllBlogs();
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        AllResponse allResponse = new AllResponse(blogs,timeElapsed);
        return new ResponseEntity<>(allResponse,HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<CustomResponse> fetchById(@PathVariable String id) throws BlogNotFoundException {
        Instant start = Instant.now();
        Blog blog = blogService.fetchById(id);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
         CustomResponse customResponse = new CustomResponse(blog, timeElapsed);
        return new ResponseEntity<>(customResponse,HttpStatus.OK);
    }

    @PutMapping("/update-blog/{id}")
    public ResponseEntity<CustomResponse> updateBlog(@PathVariable String id, @RequestBody Blog blog) throws BlogNotFoundException {
        Instant start = Instant.now();
        Blog updatedBlog = blogService.updateBlog(id,blog);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        CustomResponse customResponse = new CustomResponse(updatedBlog, timeElapsed);
        return new ResponseEntity<CustomResponse>(customResponse,HttpStatus.OK);
    }



    @DeleteMapping("/delete-blog/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable String id) throws BlogNotFoundException {
        Blog blog = blogService.deleteBlog(id);
        return new ResponseEntity<Blog>(blog,HttpStatus.ACCEPTED);
    }
}
