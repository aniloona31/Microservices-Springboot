package com.microservice1.demo;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//this class will be responsible for communicating with the microservice2
//@FeignClient(name="myFeignClient",url="http://localhost:7072/")
@FeignClient(name="MICROSERVICE2")
@LoadBalancerClient(name="MICROSERVICE2",configuration = LoadBalancerConfig.class)
public interface Microservice2Client {

	//this method should have the logic to call the microservice two. 
	//no implementation needed because of feign client.
	
	@GetMapping("/ms2/v1/messages")
	public String getMessage();
	
}
