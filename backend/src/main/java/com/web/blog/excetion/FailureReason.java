package com.web.blog.excetion;

import lombok.Data;

@Data
class FailureReason {
    private String resource;
    private String field;
    private String code;
}
