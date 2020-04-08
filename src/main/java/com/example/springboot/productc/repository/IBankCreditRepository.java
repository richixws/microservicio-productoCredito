package com.example.springboot.productc.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.productc.model.bankCredit;

import reactor.core.publisher.Mono;

@Repository
public interface IBankCreditRepository extends ReactiveMongoRepository<bankCredit, String>{

	@Query("{'numberAccount' : ?0}")
	public Mono<bankCredit> findByNumberAccount(String numberAccount);
}
