package com.wanted.pre_onboarding.recruitment.exception.user_acpplition;

import com.wanted.pre_onboarding.common.exception.CodeMessage;
import com.wanted.pre_onboarding.common.exception.WantedException;

public class AlreadyAppliedException extends WantedException {
    public AlreadyAppliedException(CodeMessage codeMessage) {
        super(codeMessage);
    }
}
