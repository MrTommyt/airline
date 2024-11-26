package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.airline.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.dto.CustomerDTO;
import com.example.airline.repositories.CustomerRepository;
import com.example.airline.services.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {
    
    @Autowired 
    private CustomerRepository customerRepository;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::toCustomerDto).toList();
    }

    @Override
    public Optional<CustomerDTO> findCustomerById(Long id) {
        return customerRepository.findById(id).map(customerMapper::toCustomerDto);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customer) {
        return customerMapper.toCustomerDto(customerRepository.save(customerMapper.fromCustomerDto(customer)));
    }

    @Override
    public Optional<CustomerDTO> updateCustomer(Long id, CustomerDTO newCustomer) {
        return customerRepository.findById(id)
        .map(customerInDB -> {
            customerInDB.setName(newCustomer.getName());
            customerInDB.setLastName(newCustomer.getLastName());
            customerInDB.setAddress(newCustomer.getAddress());
            customerInDB.setPhone(newCustomer.getPhone());
            customerInDB.setEmail(newCustomer.getEmail());

            return customerMapper.toCustomerDto(customerRepository.save(customerInDB));
        });
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDTO>findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name).stream().map(customerMapper::toCustomerDto).toList();
    }
}
