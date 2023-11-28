package com.northwind.web.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nebrass Lamouchi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String customerId;

    private String companyName;

    private String contactName;

    private String address;

    private String city;

    private String country;
}
