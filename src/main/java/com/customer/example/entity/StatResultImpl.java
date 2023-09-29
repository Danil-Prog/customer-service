package com.customer.example.entity;

import com.customer.example.entity.db.Customer;

import java.util.Set;

public class StatResultImpl implements Result{

    private final ResultType type = ResultType.stat;
    private int totalDays;
    private Set<Customer> customers;

    public StatResultImpl(int totalDays, Set<Customer> customers) {
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
