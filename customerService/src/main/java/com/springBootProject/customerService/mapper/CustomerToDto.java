package com.springBootProject.customerService.mapper;


import com.springBootProject.customerService.dto.CustomerDto;
import com.springBootProject.customerService.entities.Customer;
import org.modelmapper.ModelMapper;

public class CustomerToDto {
    public static CustomerDto customerToDto(Customer customer){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customer, CustomerDto.class);
    }
}