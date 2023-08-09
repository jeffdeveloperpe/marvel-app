package com.openpay.marvel.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.openpay")
public class MarvelAppApplication {


    public static void main(String[] args) {
        SpringApplication.run(MarvelAppApplication.class, args);
    }
}
