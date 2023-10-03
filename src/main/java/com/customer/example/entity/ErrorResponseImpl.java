package com.customer.example.entity;

public class ErrorResponseImpl implements Response {

    private final ResultType type = ResultType.error;
    private String message;

    public ErrorResponseImpl() {
    }

    public ErrorResponseImpl(String message) {
        this.message = message;
    }

    public ResultType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
