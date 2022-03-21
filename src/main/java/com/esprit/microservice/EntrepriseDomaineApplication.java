package com.esprit.microservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableEurekaClient
@EnableJpaRepositories
@SpringBootApplication
public class EntrepriseDomaineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntrepriseDomaineApplication.class, args);
	}

}
