package com.example.springboot.productc.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.productc.model.bankCredit;

@Repository
public interface IBankCreditRepository extends ReactiveMongoRepository<bankCredit, String>{

}
