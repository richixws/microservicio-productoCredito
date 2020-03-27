package com.example.springboot.productc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "cuentacredito")
public class bankCredit {

	@Id
	private String idProduct;
	
	private String descripcion;
	
	private double interest;
	
	private bankCreditType creditType;

	public bankCredit(String descripcion, double interest, bankCreditType creditType) {
		super();
		this.descripcion = descripcion;
		this.interest = interest;
		this.creditType = creditType;
	}


	
}
