package com.example.springboot.productc.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Document(collection = "creditProduct")
public class bankCredit {

	@Id
	private String id;
	
	private String bank;
	
	private String typeOwner;
	
	private String productName;
	
	private String numberAccount;

	private String nameOwner;
	//
	private String dniOwner;
	
	private Double creditAmount;
	
	private Double balance;
	
	private Double consume;
	@JsonFormat(pattern = "yyyy-MM-dd")
		private Date joinDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;
	


	
}
