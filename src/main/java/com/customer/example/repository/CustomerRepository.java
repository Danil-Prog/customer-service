package com.customer.example.repository;

import com.customer.example.entity.Criteria;
import com.customer.example.entity.db.Customer;
import com.customer.example.entity.db.Product;
import com.customer.example.mapper.ObjectMapperUtil;

import java.io.IOException;
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
                Customer customer = new Customer();
                customer.setFirstname(result.getString("firstname"));
                customer.setLastname(result.getString("lastname"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Get list customer by product name and product count
    public Set<Customer> getCustomersByProductNameAndProductCount(Criteria criteria) {
        Set<Customer> customers = new HashSet<>();

        String SQL = String.format("SELECT customer.firstname, customer.lastname, " +
                "(SELECT json_agg(json_build_object('name', o.name, 'price', o.price)) AS products " +
                "FROM product o, purchases p " +
                "WHERE o.name = '%s' AND p.customer_id = customer.id) AS products " +
                "FROM customer", criteria.getProductName());

        try (ResultSet result = this.prepareStatement(SQL)) {
            while (result.next()) {
                Customer customer = new Customer();
                customer.setFirstname(result.getString("firstname"));
                customer.setLastname(result.getString("lastname"));

                try {
                    if (result.getString("products") != null) {
                        Product[] products = ObjectMapperUtil.mapToProduct(result.getString("products"));
                        customer.setProducts(products);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getCustomersProduct() {
        List<Customer> customers = new ArrayList<>();

        String SQL = "SELECT customer.lastname, customer.firstname, json_agg(json_build_object('name', product.name, 'price', product.price)) AS products " +
                "FROM purchases " +
                "LEFT JOIN customer " +
                "ON purchases.customer_id = customer.id " +
                "LEFT JOIN product " +
                "ON product.id = purchases.product_id " +
                "GROUP BY customer.id";

        try (ResultSet result = this.prepareStatement(SQL)) {
            while (result.next()) {
                Customer customer = new Customer();
                customer.setFirstname(result.getString("firstname"));
                customer.setLastname(result.getString("lastname"));

                try {
                    if (result.getString("products") != null) {
                        System.out.println(result.getString("products"));
                        Product[] products = ObjectMapperUtil.mapToProduct(result.getString("products"));
                        customer.setProducts(products);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(customer);
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
