package com.customer.example.controller;

import com.customer.example.entity.Result;
import com.customer.example.entity.Search;
import com.customer.example.entity.Stat;
import com.customer.example.service.CustomerService;
import com.customer.example.service.impl.CustomerServiceImpl;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerServiceImpl();
    }

    public Result getCustomersByCriterias(Search search) {
        return customerService.getCustomersByCriterias(search);
    }

    public Result getCustomerStats(Stat stat) {
        return customerService.getCustomersStats(stat);
    }
}
