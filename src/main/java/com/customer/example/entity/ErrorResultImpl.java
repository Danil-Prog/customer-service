package com.customer.example.entity;

public class ErrorResultImpl implements Result {

    private final ResultType type = ResultType.error;
    private String message;

    public ErrorResultImpl() {
    }

    public ErrorResultImpl(String message) {
        this.message = message;
    }

    public ResultType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
