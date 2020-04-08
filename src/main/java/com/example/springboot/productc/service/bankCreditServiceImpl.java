package com.example.springboot.productc.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.productc.customer.customerCust;
import com.example.springboot.productc.dto.customerDto;
import com.example.springboot.productc.model.bankCredit;
import com.example.springboot.productc.repository.IBankCreditRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class bankCreditServiceImpl implements IBankCreditService {

	@Autowired
	private IBankCreditRepository repository;

	@Autowired
	private customerCust ccustomer;
	
	
	@Override
	public Flux<bankCredit> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<bankCredit> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<bankCredit> save(bankCredit cp) {
		// joinDate
		if (cp.getJoinDate() == null) {
			cp.setJoinDate(new Date());
		} else {
			cp.setJoinDate(cp.getJoinDate());
		}
		// expirationDate
		if (cp.getExpirationDate() == null) {
			cp.setExpirationDate(new Date());
		} else {
			cp.setExpirationDate(cp.getExpirationDate());
		}

		// Bank
		if (cp.getBank() == null) {
			cp.setBank("-");
		} else {
			cp.setBank(cp.getBank());
		}
		// TypeOwner
		if (cp.getTypeOwner() == null) {
			cp.setTypeOwner("-");
		} else {
			cp.setTypeOwner(cp.getTypeOwner());
		}
		// ProductName
		if (cp.getProductName() == null) {
			cp.setProductName("-");
		} else {
			cp.setProductName(cp.getProductName());
		}
		// NumberProduct
		if (cp.getNumberAccount() == null) {
			cp.setNumberAccount(UUID.randomUUID().toString());
		} else {
			cp.setNumberAccount(cp.getNumberAccount());
		}

		// DniOwner
		if (cp.getDniOwner() == null) {
			cp.setDniOwner("-");
		} else {
			cp.setDniOwner(cp.getDniOwner());
		}
		// CreditAmount
		if (cp.getCreditAmount() == null) {
			cp.setCreditAmount(0.0);
		} else {
			cp.setCreditAmount(cp.getCreditAmount());
		}
		// Balance
		if (cp.getBalance() == null) {
			cp.setBalance(cp.getCreditAmount());
		} else {
			cp.setBalance(cp.getBalance());
		}
		// Consume
		if (cp.getConsume() == null) {
			cp.setConsume(0.0);
		} else {
			cp.setConsume(cp.getConsume());
		}

		return repository.save(cp);
	}

	@Override
	public Mono<bankCredit> update(bankCredit cp, String id) {
		return repository.findById(id).flatMap(c -> {
			// joinDate
			if (cp.getJoinDate() == null) {
				c.setJoinDate(c.getJoinDate());
			} else {
				c.setJoinDate(cp.getJoinDate());
			}
			// expirationDate
			if (cp.getExpirationDate() == null) {
				c.setExpirationDate(c.getExpirationDate());
			} else {
				c.setExpirationDate(cp.getExpirationDate());
			}

			// Bank
			if (cp.getBank() == null) {
				c.setBank(c.getBank());
			} else {
				c.setBank(cp.getBank());
			}
			// TypeOwner
			if (cp.getTypeOwner() == null) {
				c.setTypeOwner(c.getTypeOwner());
			} else {
				c.setTypeOwner(cp.getTypeOwner());
			}
			// ProductName
			if (cp.getProductName() == null) {
				c.setProductName(c.getProductName());
			} else {
				c.setProductName(cp.getProductName());
			}
			// NumberAccount
			if (cp.getNumberAccount() == null) {
				c.setNumberAccount(c.getNumberAccount());
			} else {
				c.setNumberAccount(UUID.randomUUID().toString());
			}
			// DniOwner
			if (cp.getDniOwner() == null) {
				c.setDniOwner(c.getDniOwner());
			} else {
				c.setDniOwner(cp.getDniOwner());
			}
			// CreditAmount
			if (cp.getCreditAmount() == null) {
				c.setCreditAmount(c.getCreditAmount());
			} else {
				c.setCreditAmount(cp.getCreditAmount());
			}
			// Balance
			if (cp.getBalance() == null) {
				c.setBalance(c.getBalance());
			} else {
				c.setBalance(cp.getBalance());
			}
			// Consume
			if (cp.getConsume() == null) {
				c.setConsume(c.getConsume());
			} else {
				c.setConsume(cp.getConsume());
			}

			return repository.save(c);
		});
	}

	@Override
	public Mono<Void> delete(bankCredit cp) {
		return repository.delete(cp);
	}

	// --------------------------------------------->
	// Métodos del webClient

	@Override
	public Flux<customerDto> findAllClients() {
		return ccustomer.findAllCustomers();
	}

	@Override
	public Mono<customerDto> createById(String id) {
		return ccustomer.createById(id);
	}

	// ------------------------------------->
	// Métodos propios
	@Override
	public Mono<bankCredit> findByNumberAccount(String numberAccount) {
		return repository.findByNumberAccount(numberAccount);
	}

	@Override
	public Mono<bankCredit> depositC(Double amount, String numberAccount) {
		return repository.findByNumberAccount(numberAccount).flatMap(c -> {
			if ((c.getBalance() + amount) > c.getCreditAmount()) {
				return Mono.error(new InterruptedException("No puede superar su crédito"));
			} else {
				c.setBalance(c.getBalance() + amount);
				c.setConsume(c.getConsume() - amount);

				return repository.save(c);
			}
		});
	}

	@Override
	public Mono<bankCredit> retiroC(Double amount, String numberAccount) {
		return repository.findByNumberAccount(numberAccount).flatMap(c -> {
			if (amount > c.getCreditAmount()) {
				return Mono.error(new InterruptedException("No puede retirar monto superior a su crédito"));
			} else if (amount > c.getBalance()) {
				return Mono.error(new InterruptedException("No puede retirar más dinero."));
			} else {
				c.setBalance(c.getBalance() - amount);
				c.setConsume(c.getConsume() + amount);

				return repository.save(c);
			}
		});
	}

}
