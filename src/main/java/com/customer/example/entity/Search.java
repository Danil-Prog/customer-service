package com.customer.example.entity;

import java.util.Arrays;

public class Search {

    private Criteria[] criterias;

    public Search() {
    }

    public Search(Criteria[] criterias) {
        this.criterias = criterias;
    }

    public Criteria[] getCriterias() {
        return criterias;
    }

    @Override
    public String toString() {
        return "criterias = " + Arrays.toString(criterias) +
                "\n}";
    }
}
