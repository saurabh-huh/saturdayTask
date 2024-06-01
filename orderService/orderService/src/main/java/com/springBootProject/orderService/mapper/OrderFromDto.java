package com.springBootProject.orderService.mapper;

import com.springBootProject.orderService.dto.OrderDto;
import com.springBootProject.orderService.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderFromDto {
    public static Order orderToDto(OrderDto orderDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(orderDto, Order.class);
    }
}
