package com.customer.example.entity;

import com.customer.example.entity.db.Customer;

import java.util.Set;

public class StatResponseImpl implements Response {

    private final ResultType type = ResultType.stat;
    private int totalDays;
    private Set<Customer> customers;
    private int totalExpenses;
    private int  avgExpenses;

    public StatResponseImpl() {
    }

    public StatResponseImpl(int totalDays, Set<Customer> customers, int totalExpenses, int avgExpenses) {
        this.totalDays = totalDays;
        this.customers = customers;
        this.totalExpenses = totalExpenses;
        this.avgExpenses = avgExpenses;
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
