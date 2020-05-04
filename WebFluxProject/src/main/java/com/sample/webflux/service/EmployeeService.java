package com.sample.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.webflux.entity.Employee;
import com.sample.webflux.repository.EmployeeRepository;
import reactor.core.publisher.Flux;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository mongorepository;

	public Flux<Employee> getEmployeeList() {
		final Flux<Employee> employeeLists = mongorepository.findAll();
		return employeeLists;
	}
}
