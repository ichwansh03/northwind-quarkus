package com.northwind.web.dto;

import com.northwind.domain.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long orderId;
    private Customer customer;
    private LocalDateTime orderDate;
    private LocalDateTime requiredDate;
    private LocalDateTime shippedDate;
    private Double subTotal;
    private Double totalPrice;
    private int totalQty;
    private Set<OrderDetailDto> orderDetails;
}
