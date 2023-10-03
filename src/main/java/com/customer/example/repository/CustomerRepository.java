package com.customer.example.repository;

import com.customer.example.entity.Criteria;
import com.customer.example.entity.Stat;
import com.customer.example.entity.db.Customer;
import com.customer.example.exception.SqlException;
import com.customer.example.mapper.ObjectMapperUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerRepository extends AbstractRepository {

    public CustomerRepository() {
    }

    // Get list customers by lastname
    public Set<Customer> getCustomersByFirstname(Criteria criteria) {
        Set<Customer> customers = new HashSet<>();

        String SQL = String.format(
                "SELECT c.firstname, c.lastname from customer c " +
                        "WHERE c.lastname='%s'", criteria.getLastName());

        try (ResultSet result = this.prepareStatement(SQL)) {
            while (result.next()) {
                Customer customer = new Customer(
                        result.getString("firstname"),
                        result.getString("lastname")
                );

                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            throw new SqlException(e.getMessage());
        }

    }

    // Gets all users and their purchases
    public Set<Customer> getAllCustomer() {
        Set<Customer> customers = new HashSet<>();

        String SQL = "SELECT json_build_object( " +
                "'firstname', firstname, " +
                "'lastname', lastname, " +
                "'purchases', (SELECT COALESCE(json_agg(json_build_object( " +
                "'name', product.name, " +
                "'price', product.price)) FILTER (WHERE purchases.product_id is not null), '[]') " +
                "FROM purchases JOIN product on product_id = product.id " +
                "WHERE customer_id = customer.id)) as customers " +
                "FROM customer";
        try (ResultSet result = this.prepareStatement(SQL)) {
            while (result.next()) {
                Customer customer = ObjectMapperUtil.mapToCustomerPurchases(result.getString("customers"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new SqlException(e.getMessage());
        }
        return customers;
    }

    // Get list customer purchases by dates range
    public List<Customer> getCustomerPurchasesByRangeDates(Stat stat) {
        List<Customer> customers = new ArrayList<>();

        String SQL = String.format(
                "SELECT json_build_object( " +
                    "'firstname', firstname, " +
                    "'lastname', lastname, " +
                    "'purchases', " +
                        "(SELECT COALESCE(json_agg(json_build_object( " +
                        "'name', product.name, " +
                        "'price', product.price)) FILTER (WHERE purchases.product_id is not null), '[]')" +
                    "FROM purchases JOIN product on product_id = product.id " +
                    "WHERE customer_id = customer.id " +
                    "AND purchases.date_of_purchase >= '%s' " +
                    "AND purchases.date_of_purchase <= '%s' " +
                    "AND extract('dow' FROM date_of_purchase) not in (6, 0))) as customers " +
                "FROM customer;", stat.getStartDate(), stat.getEndDate());
        try (ResultSet result = this.prepareStatement(SQL)) {
            while (result.next()) {
                Customer customer = ObjectMapperUtil.mapToCustomerPurchases(result.getString("customers"));
                customers.add(customer);;
            }
        } catch (SQLException e) {
            throw new SqlException(e.getMessage());
        }
        return customers;
    }
}