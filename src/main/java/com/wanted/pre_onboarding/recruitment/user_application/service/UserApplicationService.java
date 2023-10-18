package com.wanted.pre_onboarding.recruitment.user_application.service;

import com.wanted.pre_onboarding.recruitment.exception.user_acpplition.AlreadyAppliedException;
import com.wanted.pre_onboarding.recruitment.exception.user_acpplition.UserApplicationErrorMessage;
import com.wanted.pre_onboarding.recruitment.user_application.domain.UserApplication;
import com.wanted.pre_onboarding.recruitment.user_application.domain.UserApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserApplicationService {

    private final UserApplicationRepository userApplicationRepository;

    public void apply(Long userId, Long postId) {
        checkDuplicated(userId, postId);
        userApplicationRepository.save(new UserApplication(userId, postId));
    }

    private void checkDuplicated(Long userId, Long postId) {
        boolean present = userApplicationRepository.findByUserIdAndPostId(userId, postId)
                .isPresent();

        if (present) {
            throw new AlreadyAppliedException(UserApplicationErrorMessage.ALREADY_APPLIED);
        }
    }
}
