package com.wanted.pre_onboarding.recruitment.user_application.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserApplicationRepository extends JpaRepository<UserApplication, Long> {
    Optional<UserApplication> findByUserIdAndPostId(Long userId, Long postId);
}
