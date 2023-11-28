package com.northwind.domain;

import com.northwind.domain.enums.CartStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long cartId;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Product product;

    @NotNull
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    @Column(name="createddate")
    private LocalDate createdDate;
}
