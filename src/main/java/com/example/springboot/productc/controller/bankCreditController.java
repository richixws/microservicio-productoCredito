package com.example.springboot.productc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.productc.model.bankCredit;
import com.example.springboot.productc.service.IBankCreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bankcredit")
public class bankCreditController {

	@Autowired
	private IBankCreditService bankCreditService;
	
	@GetMapping("/list")
	private Flux<bankCredit> findAll(){
		
	  return this.bankCreditService.findAll();
	}
	
	@GetMapping("/list/{id}")
	private Mono<bankCredit> findById(@PathVariable String id){
		
	  return this.bankCreditService.findById(id); 
	}
	
	@PostMapping("/save")
	private Mono<bankCredit> save(@RequestBody bankCredit bankcredit){
		return this.bankCreditService.save(bankcredit);
	}
	
	@PutMapping("/{id}")
	private Mono<bankCredit> update(@RequestBody bankCredit bankcredit, @PathVariable String id){
		
		return this.bankCreditService.update(bankcredit, id);
	}
	
	@DeleteMapping("/{id}")
	private Mono<Void> delete(@PathVariable String id){
		
		return this.bankCreditService.delete(id);
	}
	
	
	
	
	
}
