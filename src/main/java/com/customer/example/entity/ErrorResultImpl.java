package com.customer.example.entity;

public class ErrorResultImpl implements Result {

    private final ResultType type = ResultType.error;
    private final String message;

    public ErrorResultImpl(String message) {
        this.message = message;
    }
}
