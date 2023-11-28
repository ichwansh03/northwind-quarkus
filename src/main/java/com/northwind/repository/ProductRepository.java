package com.northwind.repository;

import com.northwind.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategoryCategoryId(Long categoryId);

    Long countAllByCategoryCategoryId(Long categoryId);

    @Query("select p from Product p JOIN p.supplier s where s.supplierId=?1")
    List<Product> findProductBySupplierId(Long supplierId);

    List<Product> findAllByCategoryCategoryId(Long id);
}
