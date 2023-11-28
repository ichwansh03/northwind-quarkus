package com.northwind.service;


import com.northwind.domain.OrderDetail;
import com.northwind.repository.OrderDetailRepository;
import com.northwind.web.dto.OrderDetailDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
@Transactional
public class OrderDetailService {

    @Inject
    OrderDetailRepository orderDetailRepository;

    public static OrderDetailDto mapToDto(OrderDetail orderDetail) {
        return new OrderDetailDto(
                orderDetail.getOrderProductPk().getOrderId(),
                orderDetail.getOrderProductPk().getProductId(),
                orderDetail.getUnitPrice(),
                orderDetail.getQuantity(),
                orderDetail.getDiscount()
        );
    }

    public List<OrderDetailDto> findAll(Long id) {
        log.debug("Request to get all order detail");
        return this.orderDetailRepository.findAll()
                .stream()
                .map(OrderDetailService::mapToDto)
                .collect(Collectors.toList());
    }


}
