package com.example.springboot.productc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

	@Bean
	@Qualifier("customer")
	public WebClient getClient() {
		return WebClient.create("http://localhost/8103/customers");
	}
	
}
