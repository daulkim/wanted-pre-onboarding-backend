package com.wanted.pre_onboarding.recruitment.post.web.controller;

import com.wanted.pre_onboarding.common.Response;
import com.wanted.pre_onboarding.recruitment.post.service.PostService;
import com.wanted.pre_onboarding.recruitment.post.web.request.PostCreateRequest;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public Response register(@RequestBody @Valid PostCreateRequest request) {
        postService.save(
                request.getCompanyId(),
                request.getPosition(),
                request.getReward(),
                request.getContents(),
                request.getSkill());
        return Response.of();
    }
}

