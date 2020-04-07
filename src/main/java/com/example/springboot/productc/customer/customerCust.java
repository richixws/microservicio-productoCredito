package com.example.springboot.productc.customer;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.springboot.productc.dto.customerDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class customerCust {

	@Autowired
	@Qualifier("customer")
	private WebClient client;
	
	
	//METODO DEL CLIENTE
	public Flux<customerDto> findAllCustomers(){
		
		return client.get().uri("/findAll")
				           .retrieve()
				           .bodyToFlux(customerDto.class);
		
	}
	
	public Mono<customerDto> createById(String id){
		
		return client.get().uri("/findById/{id}",Collections.singletonMap("id", id))
				           .retrieve()
				           .bodyToMono(customerDto.class);
	}
	
	
	
}
