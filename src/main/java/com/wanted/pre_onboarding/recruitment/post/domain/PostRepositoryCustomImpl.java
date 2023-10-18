package com.wanted.pre_onboarding.recruitment.post.domain;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.wanted.pre_onboarding.recruitment.post.domain.QPost.post;

@RequiredArgsConstructor
@Repository
public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public List<Post> findPostsByKeyword(String keyword) {
        return queryFactory
                .select(post)
                .from(post)
                .innerJoin(post.company).fetchJoin()
                .where(searchBuilder(keyword))
                .fetch();
    }

    private BooleanBuilder searchBuilder(String keyword) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (StringUtils.isNullOrEmpty(keyword)) {
            return booleanBuilder;
        }
        return booleanBuilder.or(companyNameContains(keyword))
                .or(positionContains(keyword));
    }

    private BooleanExpression companyNameContains(String keyword) {
        if (StringUtils.isNullOrEmpty(keyword)) {
            return null;
        }
        return post.company.name.contains(keyword);
    }

    private BooleanExpression positionContains(String keyword) {
        if (StringUtils.isNullOrEmpty(keyword)) {
            return null;
        }
        return post.position.contains(keyword);
    }
}
