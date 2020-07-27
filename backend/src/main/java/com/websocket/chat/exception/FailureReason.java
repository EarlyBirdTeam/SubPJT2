package com.websocket.chat.exception;

import lombok.Data;

@Data
class FailureReason {
    private String resource;
    private String field;
    private String code;
}
