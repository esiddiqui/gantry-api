package com.es.gantry.core;

/**
 * A generic response model for non entity API responses, esp
 * when there is no real data to return e.g HTTP 400, 50x
 */
public class GenericResponse {

    private String message;

    public GenericResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}