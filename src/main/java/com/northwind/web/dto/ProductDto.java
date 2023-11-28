package com.northwind.web.dto;

import com.northwind.domain.Category;
import com.northwind.domain.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long productId;
    private String productName;
    private Double unitPrice;
    private Double unitInStock;
    private Category category;
    private Supplier supplier;
    private int discontinued;
    private Set<ProductPhotoDto> photos = new HashSet<>();

}
