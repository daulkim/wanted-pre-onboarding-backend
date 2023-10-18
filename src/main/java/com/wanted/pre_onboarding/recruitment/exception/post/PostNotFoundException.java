package com.wanted.pre_onboarding.recruitment.exception.post;

import com.wanted.pre_onboarding.common.exception.CodeMessage;
import com.wanted.pre_onboarding.common.exception.WantedException;

public class PostNotFoundException extends WantedException {
    public PostNotFoundException(CodeMessage codeMessage) {
        super(codeMessage);
    }
}
