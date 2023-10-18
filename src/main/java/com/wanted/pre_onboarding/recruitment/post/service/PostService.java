package com.wanted.pre_onboarding.recruitment.post.service;

import com.wanted.pre_onboarding.recruitment.company.domain.Company;
import com.wanted.pre_onboarding.recruitment.company.service.CompanyService;
import com.wanted.pre_onboarding.recruitment.post.domain.Post;
import com.wanted.pre_onboarding.recruitment.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final CompanyService companyService;

    public void save(Long companyId,
                     String position,
                     Long reward,
                     String contents,
                     String skill) {
        Company company = companyService.findOne(companyId);
        Post post = Post.of(company, position, reward, contents, skill);
        postRepository.save(post);
    }
}
