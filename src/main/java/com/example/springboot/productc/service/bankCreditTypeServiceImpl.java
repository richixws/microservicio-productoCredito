package com.example.springboot.productc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.productc.model.bankCreditType;
import com.example.springboot.productc.repository.IBankCreditTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class bankCreditTypeServiceImpl implements IBankCreditTypeService{

	@Autowired
	private IBankCreditTypeRepository bankcredittypeservicerepository;
	
	@Override
	public Flux<bankCreditType> findAll() {
		return this.bankcredittypeservicerepository.findAll();
	}

	@Override
	public Mono<bankCreditType> findById(String id) {
		
		return this.bankcredittypeservicerepository.findById(id);
	}

	@Override
	public Mono<bankCreditType> save(bankCreditType bankcredittype) {
	
		return this.bankcredittypeservicerepository.save(bankcredittype);
	}

	@Override
	public Mono<bankCreditType> update(bankCreditType bankcredittype, String id) {
		
		return this.bankcredittypeservicerepository.findById(id)
				.flatMap(p -> {
					p.setIdcredittype(id);
					return save(bankcredittype);
				}).switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<Void> delete(bankCreditType bankcredittype) {
	
		return this.bankcredittypeservicerepository.delete(bankcredittype);
	}

}
