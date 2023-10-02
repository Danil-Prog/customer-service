package com.customer.example.entity.db;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Customer {

    private String firstname;
    private String lastname;
    @JsonIgnore
    private List<Product> products;

    public Customer() {
        this.products = new ArrayList<>();
    }

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product[] product) {
        this.products = Arrays.asList(product);
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
                ", products = " + products +
                '}';
    }
}
