package com.customer.example.mapper;

import com.customer.example.entity.*;
import com.customer.example.entity.db.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/*
 * Map json to object
 * */
public class ObjectMapperUtil {

    public static Search mapToSearch(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(file, Search.class);
    }

    public static Stat mapToStat(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(file, Stat.class);
    }

    public static Product[] mapToProduct(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, Product[].class);
    }

    public static void mapResultToJson(File file, Response response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

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
    }
}
