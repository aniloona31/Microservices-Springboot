package com.microservice1.demo;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerConfig{

	@Bean
	public ServiceInstanceListSupplier stickyLoadBalancing(ConfigurableApplicationContext ctx) {
		return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withSameInstancePreference().build(ctx);
	}
	
}