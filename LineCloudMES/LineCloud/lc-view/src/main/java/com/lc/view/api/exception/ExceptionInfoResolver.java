package com.lc.view.api.exception;

public interface ExceptionInfoResolver <T extends Exception> {

    ExceptionInfo getExceptionInfo(T e);
}
