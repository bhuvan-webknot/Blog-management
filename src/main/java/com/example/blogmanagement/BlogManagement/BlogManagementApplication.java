package com.example.blogmanagement.BlogManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableCaching
public class BlogManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogManagementApplication.class, args);
	}

}
