package com.example.springboot.productc.service;

import com.example.springboot.productc.model.bankCreditType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankCreditTypeService {
	
	Flux<bankCreditType> findAll();
	Mono<bankCreditType> findById(String id);
	Mono<bankCreditType> save(bankCreditType bankcredittype);
	Mono<bankCreditType> update(bankCreditType bankcredittype,String id);
	Mono<Void> delete(bankCreditType bankcredittype);
	

}
