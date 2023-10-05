package com.customer.example.mapper;

import com.customer.example.dto.CustomerStatDto;
import com.customer.example.entity.db.Customer;
import com.customer.example.entity.db.Product;

import java.util.List;
import java.util.stream.Collectors;

public final class CustomerStatMapper {

    public static CustomerStatDto customerStatDto(Customer customer) {
        int exp = customer.getPurchases().stream()
                .map(Product::getPrice).mapToInt(Integer::intValue).sum();

        List<CustomerStatDto.PurchasesDto> purchases = customer.getPurchases().stream()
                .map(CustomerStatMapper::toPurchasesDto)
                .collect(Collectors.toList());

        String name = customer.getFirstname() + " " + customer.getLastname();
        return new CustomerStatDto(name, purchases, exp);
    }

    public static CustomerStatDto.PurchasesDto toPurchasesDto(Product product) {
        return new CustomerStatDto.PurchasesDto(product.getName(), product.getPrice());
    }
}
