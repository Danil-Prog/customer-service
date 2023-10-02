package com.customer.example.entity;

import java.util.HashSet;
import java.util.Set;

public class Search {

    private Set<Criteria> criterias;

    public Search() {
        this.criterias = new HashSet<>();
    }


    public Set<Criteria> getCriterias() {
        return criterias;
    }

    @Override
    public String toString() {
        return "criterias = " + criterias +
                "\n}";
    }
}
