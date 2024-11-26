package com.example.airline.controllers;

import com.example.airline.dto.CustomerDTO;
import com.example.airline.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable long id) {
        return ResponseEntity.ok(customerService.findCustomerById(id).orElse(null));
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<CustomerDTO>> findCustomerByName(@PathVariable String name) {
        return ResponseEntity.ok(customerService.findCustomerByName(name));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable long id, @RequestBody CustomerDTO newCustomer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, newCustomer).orElse(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
