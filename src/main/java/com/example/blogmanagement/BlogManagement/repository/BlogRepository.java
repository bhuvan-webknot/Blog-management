package com.example.blogmanagement.BlogManagement.repository;

import com.example.blogmanagement.BlogManagement.models.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface BlogRepository extends MongoRepository<Blog,String> {
}
