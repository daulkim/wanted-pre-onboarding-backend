package com.wanted.pre_onboarding.recruitment.post.domain;

import com.wanted.pre_onboarding.recruitment.BaseTimeEntity;
import com.wanted.pre_onboarding.recruitment.company.domain.Company;
import jakarta.persistence.*;
import lombok.*;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private Long reward;
    private String contents;
    private String skill;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public static Post of(Company company,
                          String position,
                          Long reward,
                          String contents,
                          String skill) {
        return Post.builder()
                .company(company)
                .position(position)
                .reward(reward)
                .contents(contents)
                .skill(skill)
                .build();
    }

    public void update(String position,
                       Long reward,
                       String contents,
                       String skill) {
        this.position = position;
        this.reward = reward;
        this.contents = contents;
        this.skill = skill;
    }
}
