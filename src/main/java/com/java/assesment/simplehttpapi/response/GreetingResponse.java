package com.java.assesment.simplehttpapi.response;

public class GreetingResponse implements ApiResponse {
    private final String message;

    public GreetingResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
