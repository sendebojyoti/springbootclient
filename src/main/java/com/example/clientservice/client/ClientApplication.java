package com.example.clientservice.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
public class ClientApplication implements CommandLineRunner {

	@Autowired(required = true)
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ResponseEntity <String> responseEntity = restTemplate.exchange("https://127.0.0.1:8443/sayHello", HttpMethod.GET, HttpEntity.EMPTY, String.class);
		log.info("",responseEntity.getStatusCode());

	}
}
