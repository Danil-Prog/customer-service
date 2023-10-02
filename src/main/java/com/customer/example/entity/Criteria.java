package com.customer.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Criteria {

    private String lastName;
    private String productName;
    private Integer minTimes;
    private Integer minExpenses;
    private Integer maxExpenses;
    private Integer badCustomers;

    public Criteria() {
    }

    public String getLastName() {
        return lastName;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getMinTimes() {
        return minTimes;
    }

    public Integer getMinExpenses() {
        return minExpenses;
    }

    public Integer getMaxExpenses() {
        return maxExpenses;
    }

    public Integer getBadCustomers() {
        return badCustomers;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setMinTimes(Integer minTimes) {
        this.minTimes = minTimes;
    }

    public void setMinExpenses(Integer minExpenses) {
        this.minExpenses = minExpenses;
    }

    public void setMaxExpenses(Integer maxExpenses) {
        this.maxExpenses = maxExpenses;
    }

    public void setBadCustomers(Integer badCustomers) {
        this.badCustomers = badCustomers;
    }

    @Override
    public String toString() {
        return "\nlastName = '" + lastName + '\'' +
                ", productName = '" + productName + '\'' +
                ", minTimes = " + minTimes +
                ", minExpenses = " + minExpenses +
                ", maxExpenses = " + maxExpenses +
                ", badCustomers = " + badCustomers +
                "}";
    }
}
