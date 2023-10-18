package com.wanted.pre_onboarding.recruitment.user_application.web.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserApplicationRequest {
    @NotNull
    @Min(1)
    private Long userId;

    @NotNull
    @Min(1)
    private Long postId;
}
