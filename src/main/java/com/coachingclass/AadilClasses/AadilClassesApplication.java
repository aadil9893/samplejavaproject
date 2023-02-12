package com.coachingclass.AadilClasses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.coachingclass.AadilClasses")
public class AadilClassesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AadilClassesApplication.class, args);
	}

}
