package com.wanted.pre_onboarding.recruitment.post.domain;

import java.util.List;

public interface PostRepositoryCustom {
    List<Post> findPostsByKeyword(String keyword);
}
