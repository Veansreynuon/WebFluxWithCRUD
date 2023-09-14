package com.example.demospringwebflux.controller;

import com.example.demospringwebflux.model.Employee;
import com.example.demospringwebflux.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @RequestMapping(value = {"/create","/"},
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee e){
        employeeService.create(e);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id){
        Mono<Employee> e = employeeService.findById(id);
        return new ResponseEntity<Mono<Employee>>(e, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> findByName(@RequestParam("name") String name){
        return employeeService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> findAll(){
        Flux<Employee> emps = employeeService.findAll();
        return emps;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Mono<Employee> update(@RequestBody Employee e){
        return employeeService.update(e);
    }

    public void delete(@PathVariable Integer id){
        employeeService.delete(id).subscribe();
    }


}
