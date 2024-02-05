package com.Leta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages =  "com.Leta")
public class SpringBootQuizApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuizApp.class, args);
	}

}
