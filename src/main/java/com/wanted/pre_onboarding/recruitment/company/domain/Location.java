package com.wanted.pre_onboarding.recruitment.company.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Location {
    private String country;
    private String region;
}
