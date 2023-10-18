package com.wanted.pre_onboarding.recruitment.exception.company;

import com.wanted.pre_onboarding.common.exception.CodeMessage;
import com.wanted.pre_onboarding.common.exception.WantedException;

public class CompanyNotFoundException extends WantedException {
    public CompanyNotFoundException(CodeMessage codeMessage) {
        super(codeMessage);
    }
}
