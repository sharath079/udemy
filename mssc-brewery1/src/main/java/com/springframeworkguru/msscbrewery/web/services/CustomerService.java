package com.springframeworkguru.msscbrewery.web.services;



import com.springframeworkguru.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);
    CustomerDto saveCustomer(CustomerDto customerDto);
    void updateCustomerById(UUID customerId,CustomerDto customerDto);
    void deleteById(UUID customerId);
}
