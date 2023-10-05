package com.customer.example.service.impl;

import com.customer.example.dto.CustomerDto;
import com.customer.example.dto.CustomerStatDto;
import com.customer.example.entity.*;
import com.customer.example.entity.db.Customer;
import com.customer.example.entity.db.Product;
import com.customer.example.exception.StatParseException;
import com.customer.example.mapper.CustomerMapper;
import com.customer.example.mapper.CustomerStatMapper;
import com.customer.example.repository.CustomerRepository;
import com.customer.example.service.CustomerService;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
                response.addResult(this.byLastname(criteria));

            } else if (criteria.getMinTimes() != null && criteria.getProductName() != null) {
                response.addResult(this.byProductNameAndMinTimes(criteria));

            } else if (criteria.getMinExpenses() != null && criteria.getMaxExpenses() != null) {
                response.addResult(this.byMinMaxPurchases(criteria));

            } else if (criteria.getBadCustomers() != null) {
                response.addResult(this.byPassiveBuyers(criteria));
            }
        }
        return response;
    }

    public SearchResponseImpl.Result byLastname(Criteria criteria) {
        Set<CustomerDto> customers = customerRepository.getCustomersByFirstname(criteria)
                .stream().map(CustomerMapper::customerDto).collect(Collectors.toSet());

        SearchResponseImpl.Result result = new SearchResponseImpl.Result();
        result.setCriteria(criteria);
        result.setCustomers(customers);

        return result;
    }

    public SearchResponseImpl.Result byProductNameAndMinTimes(Criteria criteria) {
        Set<Customer> customers = customerRepository.getAllCustomer();

        Set<CustomerDto> resultCustomers = new HashSet<>();
        for (Customer customer : customers) {
            long count = customer.getPurchases().stream()
                    .filter(product -> product.getName().equals(criteria.getProductName()))
                    .count();
            if (count >= criteria.getMinTimes())
                resultCustomers.add(CustomerMapper.customerDto(customer));
        }
        SearchResponseImpl.Result result = new SearchResponseImpl.Result();
        result.setCriteria(criteria);
        result.setCustomers(resultCustomers);

        return result;
    }

    public SearchResponseImpl.Result byMinMaxPurchases(Criteria criteria) {
        Set<Customer> customers = customerRepository.getAllCustomer();
        Set<CustomerDto> resultCustomers = new HashSet<>();

        for (Customer customer : customers) {
            long sum = customer.getPurchases().stream()
                    .map(Product::getPrice).mapToInt(Integer::intValue).sum();

            if (sum > criteria.getMinExpenses() && sum < criteria.getMaxExpenses())
                resultCustomers.add(CustomerMapper.customerDto(customer));
        }
        SearchResponseImpl.Result result = new SearchResponseImpl.Result();
        result.setCriteria(criteria);
        result.setCustomers(resultCustomers);

        return result;
    }

    public SearchResponseImpl.Result byPassiveBuyers(Criteria criteria) {
        Set<Customer> customers = this.customerRepository.getAllCustomer();

        Set<CustomerDto> customersDto = customers.stream().sorted(Comparator.comparingInt(o -> o.getPurchases().size()))
                .limit(criteria.getBadCustomers())
                .map(CustomerMapper::customerDto)
                .collect(Collectors.toSet());

        SearchResponseImpl.Result result = new SearchResponseImpl.Result();
        result.setCriteria(criteria);
        result.setCustomers(customersDto);

        return result;
    }

    @Override
    public Response getCustomersStats(Stat stat) {
        this.isValidDateFormat(stat);
        int days = (int) this.getTotalDays(stat.getStartDate(), stat.getEndDate());

        StatResponseImpl response = new StatResponseImpl();

        Set<CustomerStatDto> customers = this.customerRepository.getCustomerPurchasesByRangeDates(stat)
                .stream()
                .filter(customer -> !customer.getPurchases().isEmpty())
                .map(CustomerStatMapper::customerStatDto).collect(Collectors.toSet());

        int countCustomers = customers.size();
        int sumPurchases = customers.stream()
                .map(CustomerStatDto::getTotalExpenses).mapToInt(Integer::intValue).sum();

        int avg = 0;
        if (sumPurchases != 0) {
            avg = sumPurchases / countCustomers;
        }
        response.setCustomers(customers);
        response.setTotalDays(days);
        response.setTotalExpenses(sumPurchases);
        response.setAvgExpenses(avg);

        return response;
    }

    // Check date format
    public void isValidDateFormat(Stat stat) {
        if (stat.getStartDate().after(stat.getEndDate()))
            throw new StatParseException("Начальная дата не может быть больше конечной.");
    }

    // We get the number of days between periods
    public long getTotalDays(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
