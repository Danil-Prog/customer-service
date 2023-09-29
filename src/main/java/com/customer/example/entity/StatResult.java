package com.customer.example.entity;

import java.util.Set;

public class StatResult {

    private final ResultType type = ResultType.stat;
    private int totalDays;
    private Set<Customer> customers;

    public StatResult(int totalDays, Set<Customer> customers) {
        this.totalDays = totalDays;
        this.customers = customers;
    }

    public ResultType getType() {
        return type;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }
}
