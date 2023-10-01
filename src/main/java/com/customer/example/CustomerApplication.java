package com.customer.example;

import com.customer.example.controller.CustomerController;
import com.customer.example.entity.Result;
import com.customer.example.entity.Search;
import com.customer.example.entity.Stat;
import com.customer.example.mapper.ObjectMapperUtil;
import com.customer.example.utils.ArgumentsSetting;

import java.io.IOException;

public class CustomerApplication {
    public static void main(String[] args) throws IOException {
        ArgumentsSetting argumentsSetting = new ArgumentsSetting();
        argumentsSetting.parseArguments(args);

        CustomerController customerController = new CustomerController();
        Result result = null;

        switch (argumentsSetting.getTypeOperation()) {
            case search:
                Search search = ObjectMapperUtil.mapToSearch(argumentsSetting.getInput());
                result = customerController.getCustomersByCriterias(search);
                break;
            case stat:
                Stat stat = ObjectMapperUtil.mapToStat(argumentsSetting.getInput());
                result = customerController.getCustomerStats(stat);
                break;
        }

        if (result != null) {
            ObjectMapperUtil.mapResultToJson(argumentsSetting.getOutput(), result);
        }
    }
}
