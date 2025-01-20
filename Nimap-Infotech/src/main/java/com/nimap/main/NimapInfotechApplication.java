package com.nimap.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class NimapInfotechApplication {

	public static void main(String[] args) {
		
		System.out.println("This is the Product API application");
		SpringApplication.run(NimapInfotechApplication.class, args);
	}

}
