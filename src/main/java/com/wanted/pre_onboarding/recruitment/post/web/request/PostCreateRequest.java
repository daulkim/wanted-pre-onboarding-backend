package com.wanted.pre_onboarding.recruitment.post.web.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostCreateRequest {
    @NotNull
    @Min(1)
    private Long companyId;

    @NotBlank
    private String position;

    @NotNull
    @Min(1)
    private Long reward;

    @NotBlank
    private String contents;

    @NotBlank
    private String skill;
}
