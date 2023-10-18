package com.wanted.pre_onboarding.recruitment.exception.post;

import com.wanted.pre_onboarding.common.exception.CodeMessage;

public enum PostErrorMessage implements CodeMessage {

    NOT_EXIST("P001", "공고가 존재하지 않습니다.");

    private final String code;
    private final String message;

    PostErrorMessage(String code, String message) {
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
