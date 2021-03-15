package com.springframeworkguru.msscbrewery.web.services;


import com.springframeworkguru.msscbrewery.web.model.BeerDto;
import com.springframeworkguru.msscbrewery.web.model.BeerDto1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().uuid(UUID.randomUUID())
                .beerName("Blue Moon")
                .beerStyle("Orange")
                .build();
    }

    @Override
    public BeerDto1 getBeerCopyById(UUID beerId) {
        return BeerDto1.builder().uuid(UUID.randomUUID())
                .beerName("Stella")
                .build();

    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().uuid(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteBeerById(UUID beerId) {
      log.debug("Deleting with BeerId");
    }
}
