package com.customer.example.controller;

import com.customer.example.entity.*;

import java.util.ArrayList;
import java.util.HashSet;

public class CustomerController {

    public CustomerController() {

    }

    public Result getCustomersByCriterias(Search search) {
        return new SearchResultImpl(new ArrayList<>());
    }

    public Result getCustomerStats(Stat stat) {
        return new StatResultImpl(0, new HashSet<>());
    }
}
