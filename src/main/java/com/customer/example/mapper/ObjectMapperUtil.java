package com.customer.example.mapper;

import com.customer.example.entity.*;
import com.customer.example.entity.db.Customer;
import com.customer.example.entity.db.Product;
import com.customer.example.exception.JsonParseException;
import com.customer.example.exception.StatParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.File;
import java.io.IOException;

/*
 * Map json to object
 * */
public class ObjectMapperUtil {

    public static Search mapToSearch(File file) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(file, Search.class);
        } catch (IOException e) {
            throw new JsonParseException("Произошла ошибка при формировании объекта Search. Проверьте правильность входных данных." + e.getMessage());
        }
    }

    public static Stat mapToStat(File file) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(file, Stat.class);
        } catch (IOException ex) {
            throw new StatParseException("Произошла ошибка при получения дат. Проверьте правильность входных данных. Exception: " + ex.getMessage());
        }
    }

    public static Customer mapToCustomerPurchases(String json) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(json, Customer.class);
        } catch (JsonProcessingException ex) {
            throw new JsonParseException("Произошла ошибка при формировании объекта Customer. Exception: " + ex.getMessage());
        }
    }

    public static void mapResultToJson(File file, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (response instanceof ErrorResponseImpl) {
                ErrorResponseImpl errors = (ErrorResponseImpl) response;
                objectMapper.writeValue(file, errors);

            } else if (response instanceof SearchResponseImpl) {
                SearchResponseImpl search = (SearchResponseImpl) response;
                objectMapper.writeValue(file, search);

            } else if (response instanceof StatResponseImpl) {
                StatResponseImpl stat = (StatResponseImpl) response;
                objectMapper.writeValue(file, stat);
            }
        } catch (IOException ex) {
            throw new JsonParseException("Произошла ошибка при формировании результата. Exception: " + ex.getMessage());
        }
    }
}
