package com.northwind.service;


import com.northwind.domain.Cart;
import com.northwind.domain.Product;
import com.northwind.repository.CartRepository;
import com.northwind.repository.CategoryRepository;
import com.northwind.repository.ProductRepository;
import com.northwind.web.dto.CartDto;
import com.northwind.web.dto.ProductDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
@Transactional
public class CartService {

    @Inject
    CartRepository cartRepository;


    public static CartDto mapToDto(Cart cart) {
        return new CartDto(
                cart.getCartId(),
                ProductService.mapToDto(cart.getProduct()),
                CustomerService.mapToDto(cart.getCustomer()),
                cart.getStatus().name(),
                cart.getCreatedDate()
        );
    }

    public List<CartDto> findAll() {
        log.debug("Request to get all Carts");
        return this.cartRepository.findAll()
                .stream()
                .map(CartService::mapToDto)
                .collect(Collectors.toList());
    }

    @CircuitBreaker(requestVolumeThreshold = 4)
    public Integer getExternalAPI(){
        return 0;
    }


}
