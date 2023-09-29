package com.customer.example.entity;

import java.util.List;
import java.util.Set;

public class SearchResult {

    private final ResultType type = ResultType.search;
    private List<Result> results;

    public SearchResult(List<Result> results) {
        this.results = results;
    }

    public static class Result {
        private Criteria criteria;
        private Set<Customer> results;

        public Result(Criteria criteria, Set<Customer> results) {
            this.criteria = criteria;
            this.results = results;
        }
    }
}
