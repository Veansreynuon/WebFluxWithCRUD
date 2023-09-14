package com.example.demospringwebflux.dao;

import com.example.demospringwebflux.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {
    Flux<Employee> findByName(final String name);
}
