package com.customer.example.exception;

import com.customer.example.entity.ErrorResponseImpl;
import com.customer.example.mapper.ObjectMapperUtil;
import com.customer.example.utils.ArgumentsSettingManager;

import java.io.File;

public class SqlException extends RuntimeException {

    public SqlException(String message) {
        ErrorResponseImpl errorResponse = new ErrorResponseImpl();
        errorResponse.setMessage("Возникли ошибки при выполнение sql запроса, проверьте правильность данных в бд. Подробнее: " + message);

        File output = ArgumentsSettingManager.getInstance().getOutput();

        ObjectMapperUtil.mapResultToJson(output, errorResponse);
    }
}
