package com.example.UserRegistrationBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UserRegistrationBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationBootApplication.class, args);	 
        
	}

}
