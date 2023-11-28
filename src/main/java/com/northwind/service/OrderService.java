package com.northwind.service;


import com.northwind.domain.Order;
import com.northwind.repository.OrderRepository;
import com.northwind.web.dto.OrderDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
@Transactional
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    public static OrderDto mapToDto(Order order) {

        var orderDetail = order.getOrderDetails().stream().map(OrderDetailService::mapToDto).collect(Collectors.toSet());

        return new OrderDto(
                order.getOrderId(),
                order.getCustomer(),
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                order.getSubTotal(),
                order.getTotalPrice(),
                order.getTotalQty(),
                orderDetail
        );
    }

    public List<OrderDto> findAll() {
        log.debug("Request to get all order");
        return this.orderRepository.findAll()
                .stream()
                .map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }


}
