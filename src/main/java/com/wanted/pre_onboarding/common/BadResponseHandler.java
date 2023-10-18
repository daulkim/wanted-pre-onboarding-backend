package com.wanted.pre_onboarding.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BadResponseHandler {

    @ExceptionHandler(Exception.class)
    public Object internalException(Exception ex) {
        ex.printStackTrace();
        return Response.of(ex);
    }
}
