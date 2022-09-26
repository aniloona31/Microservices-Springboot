package com.microservices.currencyexchangeservice.Controller;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
//import io.github.resilience4j.retry.annotation.Retry;


@RestController
public class CircuitBreakerController {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(CircuitBreakerController.class);
		
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	@CircuitBreaker(name = "default",fallbackMethod = "hardcodedResponse")
//	@RateLimiter(name = "default")
	@GetMapping("/sample-api")
	public String sampleApi() {
		logger.info("retrying sample api");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/get",String.class);
		return response.getBody();
	}
	
	public String hardcodedResponse(Exception ex) {
		return "Fail to load sample-api";
	}
}


