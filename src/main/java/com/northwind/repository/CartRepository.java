package com.northwind.repository;

import com.northwind.domain.Cart;
import com.northwind.domain.enums.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByStatus(CartStatus status);

    List<Cart> findByStatusAndCustomerCustomerId(CartStatus status,Long customerId);
}
