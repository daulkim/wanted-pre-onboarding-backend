package com.wanted.pre_onboarding.recruitment.post.service;

import com.wanted.pre_onboarding.recruitment.company.domain.Company;
import com.wanted.pre_onboarding.recruitment.company.service.CompanyService;
import com.wanted.pre_onboarding.recruitment.exception.post.PostErrorMessage;
import com.wanted.pre_onboarding.recruitment.exception.post.PostNotFoundException;
import com.wanted.pre_onboarding.recruitment.post.domain.Post;
import com.wanted.pre_onboarding.recruitment.post.domain.PostRepository;
import com.wanted.pre_onboarding.recruitment.post.service.response.PostResponse;
import com.wanted.pre_onboarding.recruitment.post.service.response.PostsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Transactional
@RequiredArgsConstructor
@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final CompanyService companyService;

    @Transactional(readOnly = true)
    public List<PostsResponse> search(String keyword) {
        return postRepository.findPostsByKeyword(keyword)
                .stream()
                .map(PostsResponse::postsOf)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public PostResponse findOne(Long postId) {
        Post post = findById(postId);
        List<Long> companyPostIds = postRepository.findAllByIdNotAndCompanyId(postId, post.getCompany().getId())
                .stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        return PostResponse.of(post, companyPostIds);
    }

    public void save(Long companyId,
                     String position,
                     Long reward,
                     String contents,
                     String skill) {
        Company company = companyService.findOne(companyId);
        Post post = Post.of(company, position, reward, contents, skill);
        postRepository.save(post);
    }

    public void update(Long postId,
                       String position,
                       Long reward,
                       String contents,
                       String skill) {
        findById(postId)
                .update(position, reward, contents, skill);
    }

    public void delete(Long postId) {
        postRepository.delete(findById(postId));
    }

    private Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(PostErrorMessage.NOT_EXIST));
    }
}
