package com.order.management.jobs.jobscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.order.management.jobs.jobscheduling")
public class JobschedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobschedulingApplication.class, args);
	}

	@Bean
	public RestTemplate injectRestTemplate(){
		return new RestTemplate();
	}
}
