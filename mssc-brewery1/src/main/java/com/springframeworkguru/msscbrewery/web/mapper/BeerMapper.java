package com.springframeworkguru.msscbrewery.web.mapper;

import com.springframeworkguru.msscbrewery.web.domain.Beer;
import com.springframeworkguru.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
