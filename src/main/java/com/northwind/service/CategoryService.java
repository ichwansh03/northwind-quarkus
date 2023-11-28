package com.northwind.service;

import com.northwind.domain.Category;
import com.northwind.repository.CategoryRepository;
import com.northwind.repository.ProductRepository;
import com.northwind.web.dto.CategoryDto;
import com.northwind.web.dto.ProductDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
@Transactional
public class CategoryService {
    @Inject
    CategoryRepository categoryRepository;

    @Inject
    ProductRepository productRepository;

    public static CategoryDto mapToDto(Category category,Long productsCount){
        return new CategoryDto(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getDescription(),
                productsCount

        );
    }

    public List<CategoryDto> findAll(){
        log.debug("request to get all categories");
        return this.categoryRepository.findAll()
                .stream()
                .map(category -> mapToDto(category,productRepository.countAllByCategoryCategoryId(category.getCategoryId())))
                .collect(Collectors.toList());

        //.map(category -> mapToDto(category))
        //.map(CategoryService::mapToDto)
    }

    public CategoryDto create(CategoryDto categoryDto){
        log.debug("request to create category : {}",categoryDto);
        Category category = new Category(0L,categoryDto.getCategoryName(), categoryDto.getDescription());
        return mapToDto(this.categoryRepository
                .save(new Category(0L,categoryDto.getCategoryName(), categoryDto.getDescription())),0L);
    }

    public CategoryDto findById(Long id) {
        log.debug("Request to get Category : {}", id);
        return this.categoryRepository.findById(id)
                .map(category -> mapToDto(category, productRepository.countAllByCategoryCategoryId(0L)))
                .orElseThrow(() -> new IllegalStateException("Category does not exist!"));
    }

    public List<ProductDto> findProductsByCategoryId(Long id) {
        return this.productRepository.findAllByCategoryCategoryId(id)
                .stream()
                .map(ProductService::mapToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        log.debug("Deleting Category : {}", id);
        this.categoryRepository.deleteById(id);
    }


}
