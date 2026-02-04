package com.easyLearing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerforExceptionHandlingMicroservices1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerforExceptionHandlingMicroservices1Application.class, args);
	}

}