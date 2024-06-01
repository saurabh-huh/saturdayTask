package com.springBootProject.orderService.mapper;

import com.springBootProject.orderService.dto.OrderDto;
import com.springBootProject.orderService.entity.Order;
import org.modelmapper.ModelMapper;


public class OrderToDto {

    public static OrderDto orderToDto(Order order){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(order, OrderDto.class);
    }
}
