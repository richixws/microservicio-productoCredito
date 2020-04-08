package com.example.springboot.productc.service;

import com.example.springboot.productc.dto.customerDto;
import com.example.springboot.productc.model.bankCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankCreditService {

	//LISTAR TODOS
	public Flux<bankCredit> findAll();
	//LISTAR POR ID
	public Mono<bankCredit> findById(String id);
	//CREAR
	public Mono<bankCredit> save(bankCredit cp);
	//ACTUALIZAR
	public Mono<bankCredit> update(bankCredit cp, String id);
	//ELIMINAR
	public Mono<Void> delete(bankCredit cp);
	
	//------------------->
	//Métodos propios
	public Mono<bankCredit> findByNumberAccount(String numberAccount);
	
	public Mono<bankCredit> depositC(Double amount, String numberAccount); //Experimental
	
	public Mono<bankCredit> retiroC(Double amount, String numberAccount); //Experimental
	
	
	//------------------->
	//Métodos del webClient
	
	public Flux<customerDto> findAllClients();
	
	public Mono<customerDto> createById(String id);
 	
}
