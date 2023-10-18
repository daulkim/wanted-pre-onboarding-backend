package com.wanted.pre_onboarding.recruitment.post.service.response;

import com.wanted.pre_onboarding.recruitment.post.domain.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class PostResponse {
    private Long postId;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private Long reward;
    private String skill;
    private String contents;
    private List<Long> companyPostIds;

    public static PostResponse of(Post post, List<Long> companyPostIds) {
        return PostResponse.builder()
                .postId(post.getId())
                .companyName(post.getCompany().getName())
                .nation(post.getCompany().getLocation().getCountry())
                .region(post.getCompany().getLocation().getRegion())
                .position(post.getPosition())
                .reward(post.getReward())
                .skill(post.getSkill())
                .contents(post.getContents())
                .companyPostIds(companyPostIds)
                .build();
    }
}
