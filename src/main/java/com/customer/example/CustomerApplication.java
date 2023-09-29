package com.customer.example;

import com.customer.example.utils.ArgumentsSetting;

public class CustomerApplication {
    public static void main(String[] args) {
        ArgumentsSetting argumentsSetting = new ArgumentsSetting();
        argumentsSetting.parseArguments(args);

    }
}
