package com.customer.example.exception;

import com.customer.example.entity.ErrorResponseImpl;
import com.customer.example.mapper.ObjectMapperUtil;
import com.customer.example.utils.ArgumentsSettingManager;

import java.io.File;

public class StatParseException extends RuntimeException {

    public StatParseException() {
        ErrorResponseImpl errorResponse = new ErrorResponseImpl();
        errorResponse.setMessage("Не удается получить объект статистики, возможно формат даты введен неверно");

        File output = ArgumentsSettingManager.getInstance().getOutput();

        ObjectMapperUtil.mapResultToJson(output, errorResponse);
    }
}
