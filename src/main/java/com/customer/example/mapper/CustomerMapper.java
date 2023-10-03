package com.customer.example.mapper;

import com.customer.example.dto.CustomerDto;
import com.customer.example.entity.db.Customer;

public final class CustomerMapper {

    public static CustomerDto customerDto(Customer customer) {
        return new CustomerDto(customer.getFirstname(), customer.getLastname());
    }
}
