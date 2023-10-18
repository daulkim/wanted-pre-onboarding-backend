package com.wanted.pre_onboarding.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WantedException extends RuntimeException {
    private String code;
    private String message;
    private Object field;

    public WantedException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public WantedException(String code, String message, Object field) {
        super(message);
        this.code = code;
        this.message = message;
        this.field = field;
    }

    public WantedException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.field = cause.toString();
    }

    public WantedException(Throwable cause) {
        super(cause);
    }
}
