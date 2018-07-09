package com.guttomarttins.modeloconceitual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guttomarttins.modeloconceitual.services.S3Service;

@SpringBootApplication
public class ModeloconceitualApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(ModeloconceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uoloadFile("C:\\meustestes\\logo.png");
	}
}
