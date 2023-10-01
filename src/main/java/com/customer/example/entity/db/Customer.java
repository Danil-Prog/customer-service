package com.customer.example.entity.db;

import java.util.Objects;

public class Customer {

    private String firstname;
    private String lastname;
    private Profile profile;

    public Customer() {
    }

    public Customer(String firstname, String lastname, Profile profile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profile = profile;
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

    public Profile getProfile() {
        return profile;
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
                ", profile = " + profile +
                '}';
    }

    public static class Profile {
        public int id;

        @Override
        public String toString() {
            return "Profile{" +
                    "id = " + id +
                    '}';
        }
    }
}
