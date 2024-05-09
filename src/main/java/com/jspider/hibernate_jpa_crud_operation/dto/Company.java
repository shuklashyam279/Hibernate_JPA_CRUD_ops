package com.jspider.hibernate_jpa_crud_operation.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Company {
	@Id
	private int id;
	private String name;
	private String email;
	private String address;
	private int noOfEmployee;
	

}
