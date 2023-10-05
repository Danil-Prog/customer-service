package com.customer.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criteria criteria = (Criteria) o;
        return Objects.equals(lastName, criteria.lastName) && Objects.equals(productName, criteria.productName) && Objects.equals(minTimes, criteria.minTimes) && Objects.equals(minExpenses, criteria.minExpenses) && Objects.equals(maxExpenses, criteria.maxExpenses) && Objects.equals(badCustomers, criteria.badCustomers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, productName, minTimes, minExpenses, maxExpenses, badCustomers);
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
