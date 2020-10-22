package com.example.lms.exceptions;

public class LibError {
    private int errorCode;
    private String errorMessage;

    public LibError() {
    }

    public LibError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
