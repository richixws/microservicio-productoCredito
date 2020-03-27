package com.example.springboot.productc.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.productc.model.bankCreditType;

@Repository
public interface IBankCreditTypeRepository extends ReactiveMongoRepository<bankCreditType, String>{

}
