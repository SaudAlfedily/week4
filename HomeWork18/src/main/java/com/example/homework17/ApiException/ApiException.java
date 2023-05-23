package com.example.homework17.ApiException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiException extends RuntimeException{
    public ApiException(String massage) {
        super(massage);
    }
}
