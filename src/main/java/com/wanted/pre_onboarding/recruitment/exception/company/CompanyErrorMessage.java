package com.wanted.pre_onboarding.recruitment.exception.company;

import com.wanted.pre_onboarding.common.exception.CodeMessage;

public enum CompanyErrorMessage implements CodeMessage {

    NOT_EXIST("C001", "회사가 존재하지 않습니다.");

    private final String code;
    private final String message;

    CompanyErrorMessage(String code, String message) {
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
