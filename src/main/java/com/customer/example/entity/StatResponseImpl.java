package com.customer.example.entity;

import com.customer.example.dto.CustomerStatDto;

import java.util.Set;

public class StatResponseImpl implements Response {

    private final ResultType type = ResultType.stat;
    private int totalDays;
    private Set<CustomerStatDto> customers;
    private int totalExpenses;
    private int  avgExpenses;

    public StatResponseImpl() {
    }

    public StatResponseImpl(int totalDays, Set<CustomerStatDto> customers, int totalExpenses, int avgExpenses) {
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

    public Set<CustomerStatDto> getCustomers() {
        return customers;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public int getAvgExpenses() {
        return avgExpenses;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public void setCustomers(Set<CustomerStatDto> customers) {
        this.customers = customers;
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public void setAvgExpenses(int avgExpenses) {
        this.avgExpenses = avgExpenses;
    }
}
