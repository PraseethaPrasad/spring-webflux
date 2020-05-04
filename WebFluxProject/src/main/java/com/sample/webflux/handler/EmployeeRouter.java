package com.sample.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.sample.webflux.entity.Employee;
import com.sample.webflux.repository.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class EmployeeRouter {

	@Autowired
	EmployeeRepository repository;

	public Mono<ServerResponse> getEmployees(final ServerRequest request) {
		final Flux<Employee> employeeList = repository.findAll();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(employeeList, Employee.class);
	}
}