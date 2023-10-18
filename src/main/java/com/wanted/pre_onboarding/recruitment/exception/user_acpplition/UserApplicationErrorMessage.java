package com.wanted.pre_onboarding.recruitment.exception.user_acpplition;

import com.wanted.pre_onboarding.common.exception.CodeMessage;

public enum UserApplicationErrorMessage implements CodeMessage {

    ALREADY_APPLIED("UA001", "이미 지원한 공고입니다.");

    private final String code;
    private final String message;

    UserApplicationErrorMessage(String code, String message) {
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
