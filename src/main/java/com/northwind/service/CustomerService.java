package com.northwind.service;


import com.northwind.domain.Customer;
import com.northwind.repository.CustomerRepository;
import com.northwind.web.dto.CustomerDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@Transactional
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;


    public static CustomerDto mapToDto(Customer customer) {
        return new CustomerDto(
                customer.getCustomerId(),
                customer.getCompanyName(),
                customer.getContactName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getCountry()
        );
    }


}
