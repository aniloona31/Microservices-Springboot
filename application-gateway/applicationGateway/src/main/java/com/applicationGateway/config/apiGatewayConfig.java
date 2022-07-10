package com.applicationGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//this class will contain the routing logic

@Configuration
public class apiGatewayConfig {
	
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route( r -> r.path("/ms1/v1/**")
				.uri("lb://MICROSERVICE1"))
				.route(r -> r.path("/ms2/v1/**")
				.uri("lb://MICROSERVICE2"))
				.build();
	}
	
}
