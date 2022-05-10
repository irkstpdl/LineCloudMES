package com.lc.model.api.exception;

public class RuntimeExceptionWithArguments extends RuntimeException {

    private String[] arguments;

    private RuntimeExceptionWithArguments() {

    }

    public RuntimeExceptionWithArguments(String message) {
        super(message);
    }

    public RuntimeExceptionWithArguments(String message, String... arguments) {
        this(message);
        this.arguments = arguments;
    }

    public String[] getArguments() {
        return arguments;
    }
}
