package com.wanted.pre_onboarding.common;

import com.wanted.pre_onboarding.common.exception.WantedException;
import lombok.Getter;

@Getter
public class Response {
    private static final short SUCCESS = 1;
    private static final short FAILURE = -1;

    private final short status;
    private final String code;
    private String message;
    private Object data;
    private Object error;

    private Response(short status, String code) {
        this.status = status;
        this.code = code;
    }

    private Response(short status, String code, String message) {
        this(status, code);
        this.message = message;
    }

    private Response(short status, String code, String message, Object error) {
        this(status, code);
        this.message = message;
        this.error = error;
    }

    public static Response of() {
        return new Response(SUCCESS, "OK");
    }

    public static Response of(WantedException e) {
        return new Response(FAILURE, e.getCode(), e.getMessage());
    }

    public static Response of(Exception e) {
        return new Response(FAILURE, "500", e.getMessage());
    }

    public Response addObject(Object data) {
        this.data = data;
        return this;
    }
}
