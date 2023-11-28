package com.northwind.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name="[order_details]")
//@IdClass(OrderProductPk.class)
public class OrderDetail {
    @EmbeddedId
    private OrderProductPk orderProductPk;


    @Column(name="unit_price")
    private Double unitPrice;

    @Column(name="quantity", nullable = false)
    private int quantity;

    @Column(name="discount")
    private float discount;

}
