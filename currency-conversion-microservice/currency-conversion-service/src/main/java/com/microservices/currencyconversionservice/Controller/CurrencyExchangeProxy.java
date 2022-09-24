package com.microservices.currencyconversionservice.Controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.currencyconversionservice.Entity.CurrencyConversion;

@FeignClient(name="currency-exchange",url="localhost:8001")
public interface CurrencyExchangeProxy {
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from,@PathVariable String to);
}
