package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableAutoConfiguration
public class AndroidLoginPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndroidLoginPracticeApplication.class, args);
	}

}
