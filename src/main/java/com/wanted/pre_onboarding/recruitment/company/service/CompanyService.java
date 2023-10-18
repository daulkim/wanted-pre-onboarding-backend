package com.wanted.pre_onboarding.recruitment.company.service;

import com.wanted.pre_onboarding.recruitment.company.domain.Company;
import com.wanted.pre_onboarding.recruitment.company.domain.CompanyRepository;
import com.wanted.pre_onboarding.recruitment.exception.company.CompanyErrorMessage;
import com.wanted.pre_onboarding.recruitment.exception.company.CompanyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company findOne(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(CompanyErrorMessage.NOT_EXIST));
    }
}
