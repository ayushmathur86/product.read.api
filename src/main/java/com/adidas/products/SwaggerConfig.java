package com.adidas.products;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Spring Boot REST API")
						.version("1.0.0")
						.description("Spring Boot REST API for Adidas Store")
						.contact(new Contact()
								.name("Ayush Mathur")
								.email("ayush.mathur@gmail.com")
								.url("https://github.com/ayushmathur86"))
						.license(new io.swagger.v3.oas.models.info.License()
								.name("Apache License Version 2.0")
								.url("https://www.apache.org/licenses/LICENSE-2.0"))
				);
	}
}
