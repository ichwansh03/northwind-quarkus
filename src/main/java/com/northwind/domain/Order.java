package com.northwind.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence")
    @SequenceGenerator(name="sequence", sequenceName="orders_product_id_seq", allocationSize=1)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "required_date")
    private LocalDateTime requiredDate;

    @Column(name = "shipped_date")
    private LocalDateTime shippedDate;

    @Column(name = "subtotal")
    private Double subTotal;

    @NotNull
    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "total_qty",nullable = true)
    private int totalQty;

    //@EqualsAndHashCode.Exclude
    //@OneToMany(mappedBy = "orderProductPk",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
/*    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "orderId")*/
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private Set<OrderDetail> orderDetails;

/*    @OneToOne
    private Cart cart;*/
}
