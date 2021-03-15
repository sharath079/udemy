package com.springframeworkguru.msscbrewery.web.controller;


import com.springframeworkguru.msscbrewery.web.model.CustomerDto;
import com.springframeworkguru.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveNewCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto saveDto=customerService.saveCustomer(customerDto);
        HttpHeaders headers= new HttpHeaders();
        headers.add("location",  "/api/v1/customer"+saveDto.getCustomerId().toString());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping({"/{customerId}"})
    public void updateCustomer(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDto customerDto) {
        customerService.updateCustomerById(customerId,customerDto);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{customerId}"})
    public void handleDelete(@PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }
}
