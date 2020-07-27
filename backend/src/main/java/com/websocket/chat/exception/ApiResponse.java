package com.websocket.chat.exception;

public interface ApiResponse<T> {
    static ApiResponse<String> failureFrom(String message) {
        return new FailureResponse(message, null);
    }
}
