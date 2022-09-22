package com.microservices.currencyexchangeservice.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.Entity.CurrencyExchange;

@RestController
public class Controller {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		CurrencyExchange currencyEchange = new CurrencyExchange(1001L,from,to,new BigDecimal(65.00));
		String port = environment.getProperty("local.server.port");
		currencyEchange.setEnvironment(port);
		return currencyEchange;
	}
	
	
}
