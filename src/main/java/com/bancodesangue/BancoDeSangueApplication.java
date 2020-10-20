package com.bancodesangue;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bancodesangue.repository.DoadorRepository;

@SpringBootApplication
public class BancoDeSangueApplication {
	@Autowired
	DoadorRepository repository;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BancoDeSangueApplication.class, args);

		System.out.println("Aplicação iniciada.");
	}

}