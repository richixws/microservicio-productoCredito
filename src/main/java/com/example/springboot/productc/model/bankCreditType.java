package com.example.springboot.productc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class bankCreditType {

	@Id
	private String idcredittype;
	
	private String descripcion;
	
	
}
