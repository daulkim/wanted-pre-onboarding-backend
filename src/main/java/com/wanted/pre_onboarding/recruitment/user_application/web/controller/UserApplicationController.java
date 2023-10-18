package com.wanted.pre_onboarding.recruitment.user_application.web.controller;

import com.wanted.pre_onboarding.common.Response;
import com.wanted.pre_onboarding.recruitment.user_application.service.UserApplicationService;
import com.wanted.pre_onboarding.recruitment.user_application.web.request.UserApplicationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-applications")
public class UserApplicationController {

    private final UserApplicationService userApplicationService;

    @PostMapping
    public Response apply(@RequestBody @Valid UserApplicationRequest request) {
        userApplicationService.apply(
                request.getUserId(),
                request.getPostId());
        return Response.of();
    }
}

