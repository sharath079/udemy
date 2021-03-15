package com.springframeworkguru.msscbreweryclient.web.client;

import com.springframeworkguru.msscbreweryclient.web.model.BeerDto;
import com.springframeworkguru.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }
    @Test
    void testSaveNewBeer(){
        BeerDto beerDto=BeerDto.builder().beerName("New Beer").build();

        URI uri =client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println("URI :: "+uri.toString());
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto=BeerDto.builder().beerName("UpdateBeer").build();
        client.updateBeer(UUID.randomUUID(),beerDto);

    }

    @Test
    void testDeleteBeer(){
        BeerDto beerDto=BeerDto.builder().beerName("Delete Beer").build();
        client.deleteBeer(UUID.randomUUID());
    }

    // CustomerDto
    @Test
    void getCustomerById(){
        CustomerDto customerDto=client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer(){
        CustomerDto customerDto=CustomerDto.builder().name("Manoj").build();

        URI uri=client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println("URI :: "+uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto=CustomerDto.builder().name("Surya").build();
        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void testDeleteCustomer() {
        CustomerDto.builder().name("manoj").build();
        client.deleteCustomer(UUID.randomUUID());
    }
}