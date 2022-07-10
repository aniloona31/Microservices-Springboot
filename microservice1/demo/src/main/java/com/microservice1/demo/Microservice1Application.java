package com.microservice1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/messages")
@EnableDiscoveryClient
@EnableFeignClients
public class Microservice1Application {

	@Autowired
	private Microservice2Client microservice2Client;
	
	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
		
	}
	
	
	@GetMapping
	public ResponseEntity<String> helloMessage() {
		
		String response = microservice2Client.getMessage();
		
		return new ResponseEntity<String>("hello from microservice 1. "+response, HttpStatus.OK);
	}
}