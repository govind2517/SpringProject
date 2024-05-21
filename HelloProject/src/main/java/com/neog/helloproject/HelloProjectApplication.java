package com.neog.helloproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class HelloProjectApplication {

	public static void main(String[] args) {
		// setting server time to UTC format always
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(HelloProjectApplication.class, args);
	}

}
