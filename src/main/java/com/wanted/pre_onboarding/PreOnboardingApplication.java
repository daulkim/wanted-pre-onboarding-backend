package com.wanted.pre_onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PreOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreOnboardingApplication.class, args);
	}

}
