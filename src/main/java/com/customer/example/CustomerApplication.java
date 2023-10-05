package com.customer.example;

import com.customer.example.controller.CustomerController;
import com.customer.example.entity.Response;
import com.customer.example.entity.Search;
import com.customer.example.entity.Stat;
import com.customer.example.mapper.ObjectMapperUtil;
import com.customer.example.utils.ArgumentsSettingManager;

public class CustomerApplication {
    public static void main(String[] args) {
        ArgumentsSettingManager argumentsSettingManager = ArgumentsSettingManager.getInstance();
        argumentsSettingManager.parseArguments(args);

        CustomerController customerController = new CustomerController();
        Response response = null;

        switch (argumentsSettingManager.getTypeOperation()) {
            case search:
                Search search = ObjectMapperUtil.mapToSearch(argumentsSettingManager.getInput());
                response = customerController.getCustomersByCriterias(search);
                break;
            case stat:
                Stat stat = ObjectMapperUtil.mapToStat(argumentsSettingManager.getInput());
                response = customerController.getCustomerStats(stat);
                break;
        }

        if (response != null) {
            ObjectMapperUtil.mapResultToJson(argumentsSettingManager.getOutput(), response);
        }
    }
}
