package com.example.springboot.productc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Document(collection = "tipocuentabancaria")
public class bankCreditType {

	@Id
	private String idcredittype;
	
	private String descripcion;
	


	public bankCreditType(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
}
