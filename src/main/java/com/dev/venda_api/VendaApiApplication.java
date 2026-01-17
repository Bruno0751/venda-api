package com.dev.venda_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class VendaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendaApiApplication.class, args);
	}

}
