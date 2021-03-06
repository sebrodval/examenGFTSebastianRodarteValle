package com.gft.bank.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GftbankZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GftbankZuulApplication.class, args);
	}

}
