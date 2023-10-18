package com.wanted.pre_onboarding.common;

import com.wanted.pre_onboarding.common.exception.BadRequestCodeMessage;
import com.wanted.pre_onboarding.common.exception.WantedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.lang.String.*;
import static java.util.stream.Collectors.joining;

@Slf4j
@RestControllerAdvice
public class BadResponseHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validationCheckErrorMessage(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage());

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(BadResponseHandler::convertErrorMessage)
                .collect(joining("\n"));

        return Response.of(new WantedException(BadRequestCodeMessage.BAD_ARGUMENT))
                .addObject(errorMessage);
    }

    @ExceptionHandler(WantedException.class)
    public Object WantedException(WantedException ex) {
        log.error(ex.getMessage());
        return Response.of(ex);
    }

    @ExceptionHandler(Exception.class)
    public Object internalException(Exception ex) {
        log.error(ex.getMessage());
        return Response.of(ex);
    }

    private static String convertErrorMessage(FieldError objectError) {
        return format("%s : %s", objectError.getField(), objectError.getDefaultMessage());
    }
}
