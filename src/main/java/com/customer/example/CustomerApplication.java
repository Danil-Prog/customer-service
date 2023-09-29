package com.customer.example;

import com.customer.example.controller.CustomerController;
import com.customer.example.entity.Result;
import com.customer.example.utils.ArgumentsSetting;

public class CustomerApplication {
    public static void main(String[] args) {
        ArgumentsSetting argumentsSetting = new ArgumentsSetting();
        argumentsSetting.parseArguments(args);

        CustomerController customerController = new CustomerController();
        Result result;

        switch (argumentsSetting.getTypeOperation()) {
            case search:
                result = customerController.getCustomersByCriterias(null);
                break;
            case stat:
                result = customerController.getCustomerStats(null);
                break;
        }

    }
}
