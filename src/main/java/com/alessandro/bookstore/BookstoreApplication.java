package com.alessandro.bookstore;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;


@SpringBootApplication
//@EnableScheduling
public class BookstoreApplication{

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BookstoreApplication.class, args);
			
	}

}
