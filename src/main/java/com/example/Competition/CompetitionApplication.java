package com.example.Competition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CompetitionApplication {

	public static void main(String[] args) {

//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		String r = bCryptPasswordEncoder.encode("admin");
//
//		System.out.println(r);

		SpringApplication.run(CompetitionApplication.class, args);
	}

}
