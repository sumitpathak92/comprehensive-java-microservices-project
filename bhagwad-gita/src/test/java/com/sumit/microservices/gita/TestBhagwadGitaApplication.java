package com.sumit.microservices.gita;

import org.springframework.boot.SpringApplication;

public class TestBhagwadGitaApplication {

	public static void main(String[] args) {
		SpringApplication.from(BhagwadGitaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
