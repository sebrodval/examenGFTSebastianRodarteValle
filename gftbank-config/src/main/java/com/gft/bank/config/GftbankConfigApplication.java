package com.gft.bank.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 * @author Sebastian Rodarte Valle
 *
 */
@EnableConfigServer
@SpringBootApplication
public class GftbankConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(GftbankConfigApplication.class, args);
	}

}
