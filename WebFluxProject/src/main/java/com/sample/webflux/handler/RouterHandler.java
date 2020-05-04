package com.sample.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterHandler {

	@Autowired
	EmployeeRouter employeeHandler;

	@Bean
	public RouterFunction<ServerResponse> handler() {
		return RouterFunctions.route(RequestPredicates.GET("/employee"), employeeHandler::getEmployees);
	}

}
