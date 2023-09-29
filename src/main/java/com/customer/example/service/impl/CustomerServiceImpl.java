package com.customer.example.service.impl;

import com.customer.example.entity.Result;
import com.customer.example.entity.Search;
import com.customer.example.entity.Stat;
import com.customer.example.repository.CustomerRepository;
import com.customer.example.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public Result getCustomersByCriterias(Search search) {
        return null;
    }

    @Override
    public Result getCustomersStats(Stat stat) {
        return null;
    }
}
