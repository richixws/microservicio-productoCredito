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

import com.example.springboot.productc.model.bankCreditType;
import com.example.springboot.productc.service.IBankCreditTypeService;

import lombok.experimental.PackagePrivate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("creditobancariotype")
public class bankCreditTypeController {

	
	@Autowired
	private IBankCreditTypeService bankcreditTypeService;
	
	@GetMapping("/list")
	private Flux<bankCreditType> findAll(){
		
		return this.bankcreditTypeService.findAll();
		
	}
	
	@GetMapping("/list/{id}")
	private Mono<bankCreditType> findById(@PathVariable String id){
		
		return this.bankcreditTypeService.findById(id);
	}
	
	@PostMapping("/save")
	private Mono<bankCreditType> save(@RequestBody bankCreditType bankcredittype){
		
		return this.bankcreditTypeService.save(bankcredittype);
	}
	
	@PutMapping("/{id}")
	private Mono<bankCreditType> update(@RequestBody bankCreditType bankcredittype, @PathVariable String id){
		return this.bankcreditTypeService.update(bankcredittype, id);
	}
	
	@DeleteMapping("/{id}")
	private Mono<Void> delete(@RequestBody bankCreditType bankcredittype){
		return this.bankcreditTypeService.delete(bankcredittype);
	}
}
