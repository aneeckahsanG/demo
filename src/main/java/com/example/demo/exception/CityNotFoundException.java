package com.example.demo.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(Long id){
        super(String.format("No CIty found for this id : %d", id));
    }
}
