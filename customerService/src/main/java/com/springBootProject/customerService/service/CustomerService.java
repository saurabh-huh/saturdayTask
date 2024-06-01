package com.springBootProject.customerService.service;

import com.springBootProject.customerService.dto.CustomerDto;
import com.springBootProject.customerService.entities.Customer;
import com.springBootProject.customerService.mapper.CustomerFromDto;
import com.springBootProject.customerService.mapper.CustomerToDto;
import com.springBootProject.customerService.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto createCustomer(CustomerDto customerDto){
        Customer customer = customerRepository.save(CustomerFromDto.customerFromDto(customerDto));
        customerDto.setId(customer.getId());
        return CustomerToDto.customerToDto(customer);
    }

    public CustomerDto getCustomerById(UUID id){
        return CustomerToDto.customerToDto(customerRepository.getById(id));
    }

    public List<CustomerDto> getAllCustomer(){//PageRequest pageRequest
//        Page<Customer> customerPage = customerRepository.findAll(org.springframework.data.domain.PageRequest.of(pageRequest.getPage(), pageRequest.getSize()));
//        return customerPage.stream().map(CustomerToDto::customerToDto).toList();
        return customerRepository.findAll().stream().map(customer -> {
            CustomerDto customerDto = new CustomerDto();
            return CustomerToDto.customerToDto(customer);
        }).toList();
    }

    public void deleteCustomerById(UUID id){
        customerRepository.deleteById(id);
    }
}
