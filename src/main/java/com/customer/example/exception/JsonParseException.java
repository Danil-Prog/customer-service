package com.customer.example.exception;

import com.customer.example.entity.ErrorResponseImpl;
import com.customer.example.mapper.ObjectMapperUtil;
import com.customer.example.utils.ArgumentsSettingManager;

import java.io.File;

public class JsonParseException extends RuntimeException {

    public JsonParseException(String message) {
        ErrorResponseImpl errorResponse = new ErrorResponseImpl();
        errorResponse.setMessage(message);

        File output = ArgumentsSettingManager.getInstance().getOutput();

        ObjectMapperUtil.mapResultToJson(output, errorResponse);
    }
}
