package com.customer.example.service;

import com.customer.example.entity.Response;
import com.customer.example.entity.Search;
import com.customer.example.entity.Stat;

public interface CustomerService {

    Response getCustomersByCriterias(Search search);
    Response getCustomersStats(Stat stat);
}
