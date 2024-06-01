package com.springBootProject.orderService.service;

import com.springBootProject.orderService.customer.client.CustomerClient;
import com.springBootProject.orderService.customer.model.CustomerDto;
import com.springBootProject.orderService.dto.OrderDto;
import com.springBootProject.orderService.dto.PageRequest;
import com.springBootProject.orderService.entity.Order;
import com.springBootProject.orderService.exception.CustomException;
import com.springBootProject.orderService.mapper.OrderFromDto;
import com.springBootProject.orderService.mapper.OrderToDto;
import com.springBootProject.orderService.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Response;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerClient customerClient;
    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {
        Response<CustomerDto> customerResponse = null;
        try {
            customerResponse = customerClient.getCustomerById(orderDto.getCustomerId()).execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!customerResponse.isSuccessful()) {
            throw new CustomException("Customer not found with id: " + orderDto.getCustomerId());
        }

        Order order = new Order();
        orderRepository.save(OrderFromDto.orderToDto(orderDto));
        orderDto.setId(order.getId());
        return orderDto;
    }

    public OrderDto getOrderById(UUID id){
        return OrderToDto.orderToDto( orderRepository.getById(id));
    }

    public void deleteOrderById(UUID id){
        orderRepository.deleteById(id);
    }

    public List<OrderDto> getAllOrders(PageRequest pageRequest){
        Page<Order> orderPage = orderRepository.findAll(org.springframework.data.domain.PageRequest.of(pageRequest.getPage(), pageRequest.getSize()));
        return orderPage.stream().map(OrderToDto::orderToDto).toList();
    }
}
