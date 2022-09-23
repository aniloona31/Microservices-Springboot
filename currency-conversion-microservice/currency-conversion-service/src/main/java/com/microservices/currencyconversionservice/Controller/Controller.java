package com.microservices.currencyconversionservice.Controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.currencyconversionservice.Entity.CurrencyConversion;

@RestController
public class Controller {

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,@PathVariable String to,@PathVariable int quantity) {
		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> entity = new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,uriVariables);
		CurrencyConversion currencyConversion = entity.getBody();
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(currencyConversion.getConversionMultiple().multiply(new BigDecimal(currencyConversion.getQuantity())));
		return currencyConversion;
	}
}
