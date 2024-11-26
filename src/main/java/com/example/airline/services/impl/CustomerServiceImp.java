package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.models.Customer;
import com.example.airline.repositories.CustomerRepository;
import com.example.airline.services.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {
    
    @Autowired 
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> updateCustomer(Long id, Customer newCustomer) {
        return customerRepository.findById(id)
        .map(customerInDB -> {
            customerInDB.setName(newCustomer.getName());
            customerInDB.setLastName(newCustomer.getLastName());
            customerInDB.setAddress(newCustomer.getAddress());
            customerInDB.setPhone(newCustomer.getPhone());
            customerInDB.setEmail(newCustomer.getEmail());

            return customerRepository.save(customerInDB);
        });
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer>findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }
}
