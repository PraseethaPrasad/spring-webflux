package com.sample.webflux.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Data
@Document(collection = "employee")
public class Employee {

	@Field(value = "emp_id")
	private Integer employeeId;

	@Field(value = "first_name")
	private String firstName;

	@Field(value = "last_name")
	private String lastName;

	@Field(value = "cardNo")
	private String cardNumber;

	@Field
	private String designation;

	@Field
	private String role;

}
