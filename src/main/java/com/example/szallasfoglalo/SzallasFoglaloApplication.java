package com.example.szallasfoglalo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SzallasFoglaloApplication {
	public static void main(String[] args) {
		SpringApplication.run(SzallasFoglaloApplication.class, args);
    }
}
