package com.customer.example.service.impl;

import com.customer.example.entity.*;
import com.customer.example.entity.db.Customer;
import com.customer.example.repository.CustomerRepository;
import com.customer.example.service.CustomerService;

import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public Response getCustomersByCriterias(Search search) {
        SearchResponseImpl response = new SearchResponseImpl();

        for (Criteria criteria : search.getCriterias()) {
            if (criteria.getLastName() != null) {
                Set<Customer> customers = customerRepository.getCustomersByFirstname(criteria);

                SearchResponseImpl.Result result = new SearchResponseImpl.Result();
                result.setCriteria(criteria);
                result.setCustomers(customers);

                response.addResult(result);
            } else if (criteria.getProductName() != null && criteria.getMinTimes() != null) {
                Set<Customer> customers = customerRepository.getCustomersByProductNameAndProductCount(criteria);

                SearchResponseImpl.Result result = new SearchResponseImpl.Result();
                result.setCriteria(criteria);
                result.setCustomers(customers);

                response.addResult(result);
            }
        }
        return response;
    }

    @Override
    public Response getCustomersStats(Stat stat) {
        return null;
    }
}
