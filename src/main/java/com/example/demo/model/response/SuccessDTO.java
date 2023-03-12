package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessDTO<T> implements java.io.Serializable {
    private T details;
    private int length = 1;
    private String message = null;
    public SuccessDTO(T details, int length, String message) {
        this.details = details;
        this.length = length;
        this.message = message;
        if (length == 0) {
            if (this.details instanceof List) {
                this.length = ((List) this.details).size();
            }
            if (this.details instanceof Map) {
                this.length = ((Map) this.details).size();
            }
        }
    }
    public SuccessDTO(T details, String message) {
        this.details = details;
        this.message = message;
        if (this.details instanceof List) {
            this.length = ((List) this.details).size();
        }
        if (this.details instanceof Map) {
            this.length = ((Map) this.details).size();
        }
    }
    public SuccessDTO(T details, Integer length) {
        this.details = details;
        this.length = length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }
    public SuccessDTO(T details) {
        this.details = details;
        if (this.details instanceof List) {
            this.length = ((List) this.details).size();
        }
        if (this.details instanceof Map) {
            this.length = ((Map) this.details).size();
        }
    }
    public T getDetails() {
        return details;
    }
    public void setDetails(T details) {
        this.details = details;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
//Actual Response details
