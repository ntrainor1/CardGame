package com.cardgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.cardgame"})
@SpringBootApplication
public class BlackjackRestApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(BlackjackRestApplication.class, args);
	}
}