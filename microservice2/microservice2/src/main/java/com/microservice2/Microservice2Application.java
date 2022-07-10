package com.microservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@RequestMapping("/messages")
@EnableDiscoveryClient
public class Microservice2Application {

	@Autowired
	private ServerProperties serverProperties;
	
	@Value("${welcome.message}")
	String welcomeMessage;
	
	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}
	
	@GetMapping
	public ResponseEntity<String> getMessage(){
		System.out.println("this is the port : " +  serverProperties.getPort());
		return new ResponseEntity<String>("this is microservice 2." + welcomeMessage ,HttpStatus.OK);
	}

}
