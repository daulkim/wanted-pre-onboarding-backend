package com.wanted.pre_onboarding.recruitment.user_application.web.controller;

import com.wanted.pre_onboarding.common.Response;
import com.wanted.pre_onboarding.recruitment.user_application.service.UserApplicationService;
import com.wanted.pre_onboarding.recruitment.user_application.web.request.UserApplicationRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-applications")
public class UserApplicationController {

    private final UserApplicationService userApplicationService;

    @Operation(summary = "채용공고 지원", description = "한 공고에 한번만 지원 가능")
    @PostMapping
    public Response apply(@RequestBody @Valid UserApplicationRequest request) {
        userApplicationService.apply(
                request.getUserId(),
                request.getPostId());
        return Response.of();
    }
}

