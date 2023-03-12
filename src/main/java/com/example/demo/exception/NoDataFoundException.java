package com.example.demo.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(){
        super("No data was found");
    }
}
