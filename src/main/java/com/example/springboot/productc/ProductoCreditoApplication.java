package com.example.springboot.productc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import com.example.springboot.productc.model.bankCredit;
import com.example.springboot.productc.model.bankCreditType;
import com.example.springboot.productc.repository.IBankCreditRepository;
import com.example.springboot.productc.repository.IBankCreditTypeRepository;


import reactor.core.publisher.Flux;

@EnableEurekaClient
@SpringBootApplication
public class ProductoCreditoApplication implements CommandLineRunner {

	@Autowired
	private IBankCreditRepository bankCreditRespository;

	@Autowired
	private IBankCreditTypeRepository bankCreditTypeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductoCreditoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		bankCreditType bankcredittype1 = new bankCreditType("personal");
		bankCreditType bankcredittype2 = new bankCreditType("empresarial");
		bankCreditType bankcredittype3 = new bankCreditType("tarjeta credito");
		bankCreditType bankcredittype4 = new bankCreditType("adelanto efectivo");

		Flux.just(bankcredittype1, bankcredittype2, bankcredittype3,bankcredittype4)
		.flatMap(tip -> bankCreditTypeRepository.save(tip))
				.thenMany(Flux
				.just(new bankCredit("credito", 1,bankcredittype1),
				      new bankCredit("credito", 1, bankcredittype2),
					  new bankCredit("credito", 2, bankcredittype3),
					  new bankCredit("credito", 2, bankcredittype4))
				.flatMap(bankcredit -> bankCreditRespository.save(bankcredit)))
				.subscribe();

	}
}
