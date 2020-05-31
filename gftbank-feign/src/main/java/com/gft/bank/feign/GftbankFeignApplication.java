package com.gft.bank.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class GftbankFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(GftbankFeignApplication.class, args);
	}

}
