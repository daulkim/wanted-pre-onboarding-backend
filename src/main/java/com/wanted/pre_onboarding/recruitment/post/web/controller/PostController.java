package com.wanted.pre_onboarding.recruitment.post.web.controller;

import com.wanted.pre_onboarding.common.Response;
import com.wanted.pre_onboarding.recruitment.post.service.PostService;
import com.wanted.pre_onboarding.recruitment.post.web.request.PostCreateRequest;
import com.wanted.pre_onboarding.recruitment.post.web.request.PostUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Operation(summary = "채용공고 목록 조회")
    @GetMapping
    public Response posts(@RequestParam(required = false) String keyword) {
        return Response.of()
                .addObject(postService.search(keyword));
    }

    @Operation(summary = "채용공고 상세 조회", description = "조회된 채용공고의 회사가 올린 다른 채용공고 목록을 포함")
    @GetMapping("/{id}")
    public Response post(@PathVariable Long id) {
        return Response.of()
                .addObject(postService.findOne(id));
    }

    @Operation(summary = "채용공고 등록")
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

    @Operation(summary = "채용공고 수정")
    @PatchMapping("/{id}")
    public Response edit(@PathVariable Long id,
                         @RequestBody @Valid PostUpdateRequest request) {
        postService.update(
                id,
                request.getPosition(),
                request.getReward(),
                request.getContents(),
                request.getSkill());
        return Response.of();
    }

    @Operation(summary = "채용공고 삭제", description = "지원자가 있는 채용공고는 삭제되지 않음")
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        postService.delete(id);
        return Response.of();
    }
}

