package com.vedpulse.bhagavatam;

import org.springframework.boot.SpringApplication;

public class TestSrimadBhagavatamApplication {

	public static void main(String[] args) {
		SpringApplication.from(SrimadBhagavatamApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
