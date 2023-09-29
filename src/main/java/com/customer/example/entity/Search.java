package com.customer.example.entity;

public class Search {

    private Criteria[] criterias;

    public Search(Criteria[] criterias) {
        this.criterias = criterias;
    }

    public Criteria[] getCriterias() {
        return criterias;
    }

}
