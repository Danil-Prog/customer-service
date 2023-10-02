package com.customer.example.entity;

import com.customer.example.entity.db.Customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchResponseImpl implements Response {

    private final ResultType type = ResultType.search;
    private List<Result> results;

    public SearchResponseImpl() {
        this.results = new ArrayList<>();
    }

    public SearchResponseImpl(List<Result> results) {
        this.results = results;
    }

    public ResultType getType() {
        return type;
    }

    public List<Result> getResults() {
        return results;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }


    public static class Result {
        private Criteria criteria;
        private Set<Customer> customers;

        public Result() {
            this.customers = new HashSet<>();
        }

        public Result(Criteria criteria, Set<Customer> customers) {
            this.criteria = criteria;
            this.customers = customers;
        }

        public Criteria getCriteria() {
            return criteria;
        }

        public void setCriteria(Criteria criteria) {
            this.criteria = criteria;
        }

        public Set<Customer> getCustomers() {
            return customers;
        }

        public void setCustomers(Set<Customer> customers) {
            this.customers = customers;
        }
    }
}
