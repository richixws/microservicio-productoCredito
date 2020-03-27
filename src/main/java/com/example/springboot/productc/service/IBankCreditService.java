package com.example.springboot.productc.service;

import com.example.springboot.productc.model.bankCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankCreditService {

	Flux<bankCredit> findAll();
	Mono<bankCredit> findById(String id);
	Mono<bankCredit> save(bankCredit bankcredit);
	Mono<bankCredit> update(bankCredit bankcredit, String id);
	Mono<Void> delete(String id);
 	
}
