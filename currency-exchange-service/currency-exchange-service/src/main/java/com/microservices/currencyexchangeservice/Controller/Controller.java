package com.microservices.currencyexchangeservice.Controller;

//import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.Entity.CurrencyExchange;
import com.microservices.currencyexchangeservice.Repository.CurrencyExchangeRepository;

@RestController
public class Controller {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		CurrencyExchange currencyEchange = repo.findByFromAndTo(from, to);
		
		if(currencyEchange == null) {
			throw new RuntimeException("unable to find");
		}
		
		String port = environment.getProperty("local.server.port");
		currencyEchange.setEnvironment(port);
		return currencyEchange;
	}
	
	
}
