package com.example.blogmanagement.BlogManagement.service;


import com.example.blogmanagement.BlogManagement.exceptions.BlogNotFoundException;
import com.example.blogmanagement.BlogManagement.models.Blog;
import com.example.blogmanagement.BlogManagement.repository.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"Blogs"})
public class BlogService {
    @Autowired
    BlogRepository blogRepository;
    final static Logger logger = LoggerFactory.getLogger(BlogService.class);


    @Cacheable("blogs")
    public List<Blog> fetchAllBlogs() {
        logger.info("Control is in the fetchAllBlogs service");
        return blogRepository.findAll();
    }



    @Cacheable(value = "blogs",key = "#id")
    public Blog fetchById(String id) throws BlogNotFoundException {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog == null) {
            throw new BlogNotFoundException("Blog not found with ID: " + id);
        }
        logger.info("Control is in the fetchById service");
        return blog;
    }


    @CacheEvict(value = "blogs",allEntries = true)
        public Blog updateBlog (String Id, Blog blog) throws BlogNotFoundException {
            Optional<Blog> isExisting = blogRepository.findById(Id);

            if (!isExisting.isPresent()) {
                throw new BlogNotFoundException("Blog with id:" + Id + " not found !!");
            }

            logger.info(blog+Id);
            Blog blogDB = isExisting.get();

            if (Objects.nonNull(blog.getTitle()) &&
                    !"".equalsIgnoreCase(blog.getTitle())) {
                blogDB.setTitle(blog.getTitle());
            }

            if (Objects.nonNull(blog.getBlogCategory()) &&
                    !"".equalsIgnoreCase(blog.getBlogCategory())) {
                blogDB.setBlogCategory(blog.getBlogCategory());
            }

            if (Objects.nonNull(blog.getAuthor()) &&
                    !"".equalsIgnoreCase(blog.getAuthor())) {
                blogDB.setAuthor(blog.getAuthor());
            }

            if (Objects.nonNull(blog.getContent()) &&
                    !"".equalsIgnoreCase(blog.getContent())) {
                blogDB.setContent(blog.getContent());
            }

            if (Objects.nonNull(blog.getPublicationDate()) &&
                    !"".equalsIgnoreCase(blog.getPublicationDate())) {
                blogDB.setPublicationDate(blog.getPublicationDate());
            }
            logger.info("Successfully updated the record !!");
            return blogRepository.save(blogDB);
        }

    @CacheEvict(value = "blogs",allEntries = true)
        public Blog createBlog (Blog blog){
            logger.info("Successfully created the record !!");
            return blogRepository.save(blog);
        }

    @CacheEvict(value = "blogs",allEntries = true)
        public Blog deleteBlog (String Id) throws BlogNotFoundException {
            Blog deletedBlog = blogRepository.findById(Id).
                    orElseThrow(() -> new BlogNotFoundException("The Blog post not found with id: " + Id));
            blogRepository.deleteById(Id);
            return deletedBlog;
        }
    }