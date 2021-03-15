package com.springguru.msscbeerservcie.web.repositories;

import com.springguru.msscbeerservcie.web.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
