package com.wanted.pre_onboarding.recruitment.post.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    List<Post> findAllByIdNotAndCompanyId(Long postId, Long companyId);
}
