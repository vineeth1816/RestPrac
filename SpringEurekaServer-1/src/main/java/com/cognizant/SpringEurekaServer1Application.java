package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaServer1Application.class, args);
	}

}
