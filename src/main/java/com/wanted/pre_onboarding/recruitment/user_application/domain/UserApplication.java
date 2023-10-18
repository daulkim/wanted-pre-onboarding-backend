package com.wanted.pre_onboarding.recruitment.user_application.domain;

import com.wanted.pre_onboarding.recruitment.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserApplication extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long postId;

    public UserApplication(Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }
}
