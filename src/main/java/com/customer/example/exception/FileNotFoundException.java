package com.customer.example.exception;

import com.customer.example.entity.ErrorResponseImpl;
import com.customer.example.mapper.ObjectMapperUtil;

import java.io.File;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String message) {
        ErrorResponseImpl errorResponse = new ErrorResponseImpl();
        errorResponse.setMessage(message);

        File output = new File("error.json");

        ObjectMapperUtil.mapResultToJson(output, errorResponse);
    }
}
