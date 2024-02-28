//package com.example.blogmanagement.BlogManagement.exceptions;
//
//import com.example.blogmanagement.BlogManagement.dto.CustomResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//    public class GlobalExceptionHandler {
//        @ExceptionHandler(BlogNotFoundException.class)
//        public ResponseEntity<CustomResponse> BlogNotFoundException(BlogNotFoundException exception) {
//            String message = exception.getMessage();
//            CustomResponse apiResponse = CustomResponse.builder()
//                    .message(message)
//                    .status(404)
//                    .success(true)
//                    .build();
//            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//        }
//    }
//}
