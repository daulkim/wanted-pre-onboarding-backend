package com.wanted.pre_onboarding.recruitment.post.service.response;

import com.wanted.pre_onboarding.recruitment.post.domain.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class PostsResponse {
    private Long postId;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private Long reward;
    private String skill;

    public static PostsResponse postsOf(Post post) {
        return PostsResponse.builder()
                .postId(post.getId())
                .companyName(post.getCompany().getName())
                .nation(post.getCompany().getLocation().getCountry())
                .region(post.getCompany().getLocation().getRegion())
                .position(post.getPosition())
                .reward(post.getReward())
                .skill(post.getSkill())
                .build();
    }
}
