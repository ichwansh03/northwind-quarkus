package com.northwind.service;


import com.northwind.domain.Product;
import com.northwind.repository.CategoryRepository;
import com.northwind.repository.ProductRepository;
import com.northwind.web.dto.ProductDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
@Transactional
public class ProductService {

    @Inject
    ProductRepository productRepository;
    @Inject
    CategoryRepository categoryRepository;

    public static ProductDto mapToDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getUnitPrice(),
                product.getUnitInStock(),
                product.getCategory(),
                product.getSupplier(),
                product.getDiscontinued(),
                Collections.emptySet()

        );
    }

    public List<ProductDto> findAll() {
        log.debug("Request to get all Products");
        return this.productRepository.findAll()
                .stream()
                .map(ProductService::mapToDto)
                .collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        log.debug("Request to get Product : {}", id);
        return this.productRepository.findById(id)
                .map(ProductService::mapToDto)
                .orElse(null);
    }

    public ProductDto create(ProductDto productDto) {
        log.debug("Request to create Product : {}", productDto);

        Product product = new Product(productDto.getProductId(),
                productDto.getProductName(),
                productDto.getUnitPrice(),
                productDto.getUnitInStock(),
                productDto.getCategory(),
                productDto.getSupplier(),
                productDto.getDiscontinued(),
                Collections.emptySet());

        product = this.productRepository.save(product);

        return mapToDto(product);
    }

    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        this.productRepository.deleteById(id);
    }

    public List<ProductDto> findByCategoryId(Long id) {
        return this.productRepository.findByCategoryCategoryId(id).stream()
                .map(ProductService::mapToDto)
                .collect(Collectors.toList());
    }

    public Long countAll() {
        return this.productRepository.count();
    }

    public Long countByCategoryId(Long id) {
        return this.productRepository.countAllByCategoryCategoryId(id);
    }
}
