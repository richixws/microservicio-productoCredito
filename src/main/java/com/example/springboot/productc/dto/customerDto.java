package com.example.springboot.productc.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class customerDto {

	
	private String id;

	private String firstName;

	private String lastName;

	private String numDoc;

	private String address;

	private String bank;

	private String type;

	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateJoin;

	
	
	
	
}
