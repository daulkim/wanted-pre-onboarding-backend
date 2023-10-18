package com.wanted.pre_onboarding.common.exception;

public enum BadRequestCodeMessage implements CodeMessage {

    BAD_ARGUMENT("422", "BAD_ARGUMENT");

    private final String code;
    private final String message;

    BadRequestCodeMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
