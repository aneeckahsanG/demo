package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO<T> implements java.io.Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T details;
    private String message;
    public ErrorDTO(T body, String message) {
        this.details = body;
        this.message = message;
    }
    public T getDetails() {
        return details;
    }
    public void setDetails(T details) {
        this.details = details;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
