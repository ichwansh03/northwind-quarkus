package com.northwind.service;


import com.northwind.domain.ProductPhoto;
import com.northwind.repository.ProductPhotoRepository;
import com.northwind.web.dto.ProductPhotoDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
@Transactional
public class ProductPhotoService {

    @Inject
    ProductPhotoRepository productPhotoRepository;


    public static ProductPhotoDto mapToDto(ProductPhoto productPhoto) {
        return new ProductPhotoDto(
                productPhoto.getPphoId(),
                productPhoto.getPphoFilename(),
                productPhoto.getPphoFiletype(),
                productPhoto.getPphoFileSize(),
                productPhoto.getPphoFileUrl()
        );
    }

    public List<ProductPhotoDto> findAll() {
        log.debug("Request to get all Products");
        return this.productPhotoRepository.findAll()
                .stream()
                .map(ProductPhotoService::mapToDto)
                .collect(Collectors.toList());
    }
}
