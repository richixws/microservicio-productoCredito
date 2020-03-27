package com.example.springboot.productc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.productc.model.bankCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class bankCreditServiceImpl implements IBankCreditService{

	@Autowired
	private IBankCreditService bankCreditServiceImpl;
	
	
	@Override
	public Flux<bankCredit> findAll() {
		
		return this.bankCreditServiceImpl.findAll();
	}

	@Override
	public Mono<bankCredit> findById(String id) {
		
		return this.bankCreditServiceImpl.findById(id);
	}

	@Override
	public Mono<bankCredit> save(bankCredit bankcredit) {
		
		return this.bankCreditServiceImpl.save(bankcredit);
	}

	@Override
	public Mono<bankCredit> update(bankCredit bankcredit, String id) {

		return this.bankCreditServiceImpl.findById(id)
				.flatMap(p -> {
					    bankcredit.setIdProduct(id);
					    return save(bankcredit);
				   }
				).switchIfEmpty(Mono.empty());
		
	}

	@Override
	public Mono<Void> delete(String id) {
	
		return this.bankCreditServiceImpl.delete(id);
	}

}
