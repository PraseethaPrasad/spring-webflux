package com.sample.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.sample.webflux.entity.Employee;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {

}
