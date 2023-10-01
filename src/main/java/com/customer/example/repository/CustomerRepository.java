package com.customer.example.repository;

import com.customer.example.entity.Criteria;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository extends AbstractRepository {

    public CustomerRepository() {
    }

    public ResultSet getCustomersByFirstname(Criteria criteria) {
        String BY_FIRSTNAME = String.format(
                "SELECT c.firstname, c.lastname, p.name, e.date_of_purchase from customer c, product p, purchases e " +
                        "where e.customer_id=c.id and e.product_id=p.id and c.lastname='%s'", criteria.getLastName());
        try (ResultSet result = this.prepareStatement(BY_FIRSTNAME)){
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet getCustomersByProductNameAndCount(Criteria criteria) {
        String BY_PRODUCT_NAME_AND_COUNT = String.format(
                "SELECT c.firstname, c.lastname, p.name, e.date_of_purchase from customer c, product p, purchases e " +
                        "where e.customer_id=c.id and e.product_id=p.id and p.product.name='%s' and limit", criteria.getProductName());

        try (ResultSet result = this.prepareStatement(BY_PRODUCT_NAME_AND_COUNT)){
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
