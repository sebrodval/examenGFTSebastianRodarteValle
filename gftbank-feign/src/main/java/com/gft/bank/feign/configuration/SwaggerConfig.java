package com.gft.bank.feign.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.gft.bank.feign"))
				.paths(PathSelectors.any()).build().
				tags(new Tag("GFTBank", "El controlador GFT Bank Rest expone provee todos los servicios necesarios para crear, consultar, actualizar y borrar tanto clientes como cuentas bancarias del banco GFT Bank"));
	}
}
