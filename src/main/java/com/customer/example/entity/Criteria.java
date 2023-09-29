package com.customer.example.entity;

public class Criteria {

    private String lastName;
    private String productName;
    private int minTimes;
    private int minExpenses;
    private int maxExpenses;
    private int badCustomers;

    public Criteria(String lastName) {
        this.lastName = lastName;
    }

    public Criteria(String productName, int minTimes) {
        this.productName = productName;
        this.minTimes = minTimes;
    }

    public Criteria(int minExpenses, int maxExpenses) {
        this.minExpenses = minExpenses;
        this.maxExpenses = maxExpenses;
    }

    public Criteria(int badCustomers) {
        this.badCustomers = badCustomers;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setMinTimes(int minTimes) {
        this.minTimes = minTimes;
    }

    public void setMinExpenses(int minExpenses) {
        this.minExpenses = minExpenses;
    }

    public void setMaxExpenses(int maxExpenses) {
        this.maxExpenses = maxExpenses;
    }

    public void setBadCustomers(int badCustomers) {
        this.badCustomers = badCustomers;
    }
}
