package com.northwind.repository;

import com.northwind.domain.Product;
import com.northwind.domain.ProductPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPhotoRepository extends JpaRepository<ProductPhoto,Long> {
    List<ProductPhoto> findByProductProductId(Long id);
}
