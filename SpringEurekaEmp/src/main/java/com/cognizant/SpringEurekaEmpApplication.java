package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class SpringEurekaEmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaEmpApplication.class, args);
	}

}
