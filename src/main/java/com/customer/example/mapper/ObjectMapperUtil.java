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

    public static Search mapToSearch(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(file, Search.class);
    }

    public static Stat mapToStat(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(file, Stat.class);
        } catch (InvalidFormatException ex) {
            throw new StatParseException(ex.getMessage());
        }
    }

    public static Product[] mapToProduct(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, Product[].class);
    }

    // If list products in user is empty return null
    public static Customer mapToCustomerPurchases(String json) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(json, Customer.class);
        } catch (JsonProcessingException e) {
            throw new JsonParseException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
