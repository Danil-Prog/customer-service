package com.customer.example.service;

import com.customer.example.entity.Result;
import com.customer.example.entity.Search;
import com.customer.example.entity.Stat;

public interface CustomerService {

    Result getCustomersByCriterias(Search search);
    Result getCustomersStats(Stat stat);
}
