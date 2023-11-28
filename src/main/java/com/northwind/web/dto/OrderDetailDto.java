package com.northwind.web.dto;

import com.northwind.domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {

    //private OrderProductPk orderProductPk;
    private Long orderId;
    private Long productId;
    private Double unitPrice;
    private int quantity;
    private float discount;
}
