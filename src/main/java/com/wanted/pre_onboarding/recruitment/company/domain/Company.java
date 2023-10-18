package com.wanted.pre_onboarding.recruitment.company.domain;

import com.wanted.pre_onboarding.recruitment.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Company extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Embedded
    private Location location;
}
