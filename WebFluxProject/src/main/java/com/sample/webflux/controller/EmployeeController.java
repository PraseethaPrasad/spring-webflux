package com.sample.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sample.webflux.entity.Employee;
import com.sample.webflux.service.EmployeeService;
import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Employee> getEmployeeList() {
		final Flux<Employee> employeeList = service.getEmployeeList();
		return employeeList;
	}
}