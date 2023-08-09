package com.openpay.marvel;

import com.openpay.marvel.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarvelAppApplication implements CommandLineRunner {

	@Autowired private MarvelService service;

	public static void main(String[] args) {
		SpringApplication.run(MarvelAppApplication.class, args);
	}

	public void run(String... args) throws Exception {
		service.get(1011334L);
	}
}
