package com.customer.example.entity.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private String firstname;
    private String lastname;
    private List<Product> purchases;

    public Customer() {
        this.purchases = new ArrayList<>();
    }

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public List<Product> getPurchases() {
        return purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstname, customer.firstname) && Objects.equals(lastname, customer.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname = '" + firstname + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", products = " + purchases +
                '}';
    }
}
