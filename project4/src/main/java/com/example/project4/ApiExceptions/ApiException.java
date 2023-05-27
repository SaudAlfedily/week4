package com.example.project4.ApiExceptions;

public class ApiException extends RuntimeException{
    public ApiException(String massage) {
        super(massage);
    }
}
