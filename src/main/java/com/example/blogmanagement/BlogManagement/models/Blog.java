package com.example.blogmanagement.BlogManagement.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.xml.stream.events.Comment;
import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection="blogs")
public class Blog implements Serializable{
    @Id
    private String blogId;
    private String title;
    private String content;
    private String author;
    private String publicationDate;
    private String blogCategory;
//    private List<Comment> comments;
}
