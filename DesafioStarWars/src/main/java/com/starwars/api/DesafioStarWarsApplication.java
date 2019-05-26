package com.starwars.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.starwars.api.*"})
@SpringBootApplication
public class DesafioStarWarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioStarWarsApplication.class, args);
	}

}
