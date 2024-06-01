package com.springBootProject.customerService.controller;

import com.springBootProject.customerService.dto.CustomerDto;
import com.springBootProject.customerService.dto.PageRequest;
import com.springBootProject.customerService.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createUser(@Valid @RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    //@RequestParam PageRequest pageRequest
    @GetMapping
    private ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());//pageRequest
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable UUID id){
        customerService.deleteCustomerById(id);
        return null;
    }
}
