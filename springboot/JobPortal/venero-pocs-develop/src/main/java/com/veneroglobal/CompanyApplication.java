package com.veneroglobal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@ComponentScan(basePackages = "com.veneroglobal")
@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args)



	{
		SpringApplication.run(CompanyApplication.class, args);
	}

}
