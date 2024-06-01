package com.springBootProject.customerService.mapper;

import com.springBootProject.customerService.dto.CustomerDto;
import com.springBootProject.customerService.entities.Customer;
import org.modelmapper.ModelMapper;


public class CustomerFromDto {
    public static Customer customerFromDto(CustomerDto customerDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customerDto,Customer.class);
    }
}
