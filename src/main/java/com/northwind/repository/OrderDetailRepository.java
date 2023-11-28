package com.northwind.repository;

import com.northwind.domain.OrderDetail;
import com.northwind.domain.OrderProductPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderProductPk> {
    List<OrderDetail> findAll();
}
