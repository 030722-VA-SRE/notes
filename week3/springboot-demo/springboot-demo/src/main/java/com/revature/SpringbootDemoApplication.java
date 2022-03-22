package com.revature;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	// method level, not a stereotype annotation
	/*-@Bean
	public Scanner getScan() {
		return new Scanner(System.in);
	}
	*/
}
