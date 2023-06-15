package com.simpli.userauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.simpli.userauthentication")
@SpringBootApplication
public class UserauthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserauthenticationApplication.class, args);
	}

}
