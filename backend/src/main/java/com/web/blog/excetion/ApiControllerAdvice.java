package com.web.blog.excetion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiControllerAdvice {

    /**
     * 사용자 요청에 오류가 있는 경우
     */
    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            MissingServletRequestParameterException.class,
            BadRequestException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleMethodArgumentNotValidException(Exception ex) {
        log.error("Exception occurred while handling arguments", ex);
        return ApiResponse.failureFrom(
                ex.getMessage()
        );
    }

    /**
     * 서버 내부 오류
     */
    @ExceptionHandler({
            Exception.class,
            ResourceNotFoundException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse handleException(Exception ex) {
        log.error("Exception occurred", ex);
        return ApiResponse.failureFrom(
                ex.getMessage()
        );
    }
}
