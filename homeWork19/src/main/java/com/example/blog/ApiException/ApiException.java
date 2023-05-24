package com.example.blog.ApiException;

public class ApiException extends RuntimeException {
    public ApiException(String massage) {
        super(massage);
    }
}
