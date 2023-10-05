package com.customer.example.dto;

import java.util.List;
import java.util.Objects;

public class CustomerStatDto {

    private String name;
    private List<PurchasesDto> purchases;
    private int totalExpenses;

    public CustomerStatDto() {
    }

    public CustomerStatDto(String name, List<PurchasesDto> purchases, int totalExpenses) {
        this.name = name;
        this.purchases = purchases;
        this.totalExpenses = totalExpenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PurchasesDto> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchasesDto> purchases) {
        this.purchases = purchases;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerStatDto that = (CustomerStatDto) o;
        return totalExpenses == that.totalExpenses && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalExpenses);
    }

    public static class PurchasesDto {
        public String name;
        public int expenses;

        public PurchasesDto() {
        }

        public PurchasesDto(String name, int expenses) {
            this.name = name;
            this.expenses = expenses;
        }

        public String getName() {
            return name;
        }

        public int getExpenses() {
            return expenses;
        }
    }
}
