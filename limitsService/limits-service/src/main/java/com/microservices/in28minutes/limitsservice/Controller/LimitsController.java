package com.microservices.in28minutes.limitsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.in28minutes.limitsservice.Configuration.LimitsConfig;
import com.microservices.in28minutes.limitsservice.Entity.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsConfig limitConfig;
	
	@GetMapping("/limits")
	public Limits retriveLimits() {
		return new Limits(limitConfig.getMinimum(),limitConfig.getMaximum());
//		return new Limits(1,10);
	}

}
