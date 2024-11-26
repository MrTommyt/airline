package com.example.airline.services;

import com.example.airline.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    List<CustomerDTO> findAll();
    Optional<CustomerDTO> findCustomerById(Long id);
    List<CustomerDTO> findCustomerByName(String name);
    CustomerDTO createCustomer(CustomerDTO customer);
    Optional<CustomerDTO> updateCustomer(Long id, CustomerDTO newCustomer);
    void deleteCustomer(Long id);
} 
