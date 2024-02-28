package com.example.blogmanagement.BlogManagement.exceptions;

public class BlogNotFoundException extends Exception{
    public BlogNotFoundException() {
        super();
    }

    public BlogNotFoundException(String s) {
        super(s);
    }

    public BlogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogNotFoundException(Throwable cause) {
        super(cause);
    }
}
