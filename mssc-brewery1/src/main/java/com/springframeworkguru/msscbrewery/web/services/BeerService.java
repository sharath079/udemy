package com.springframeworkguru.msscbrewery.web.services;



import com.springframeworkguru.msscbrewery.web.model.BeerDto;
import com.springframeworkguru.msscbrewery.web.model.BeerDto1;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
    BeerDto1 getBeerCopyById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeerById(UUID beerId);
}
