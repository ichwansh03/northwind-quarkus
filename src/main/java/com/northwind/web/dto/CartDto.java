package com.northwind.web.dto;

import com.northwind.domain.Customer;
import com.northwind.domain.Product;
import com.northwind.domain.enums.CartStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Nebrass Lamouchi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Long cartId;
    private ProductDto productDto;
    private CustomerDto customerDto;
    private String status;
    private LocalDate createdDate;
}
