package com.java.assesment.simplehttpapi.response;

public class InvalidInputResponse implements ApiResponse {
    private final String error;

    public InvalidInputResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
