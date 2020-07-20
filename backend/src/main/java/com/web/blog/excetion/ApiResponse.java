package com.web.blog.excetion;

public interface ApiResponse<T> {
    static ApiResponse<String> failureFrom(String message) {
        return new FailureResponse(message, null);
    }
}
