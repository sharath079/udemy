package com.springguru.msscbeerservcie.web.bootstrap;

import com.springguru.msscbeerservcie.web.domain.Beer;
import com.springguru.msscbeerservcie.web.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository){
        this.beerRepository=beerRepository;

    }
    @Override
    public void run(String... args) throws Exception {
           loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() ==0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(33000000L)
                    .price(new BigDecimal("12.95"))
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cats")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(300)
                    .upc(430100000L)
                    .price(new BigDecimal("15.99"))
                    .build());

        }

        System.out.println("Loaded Beers :: "+beerRepository.count());
        //System.out.println("Beer :: "+beerRepository.findAll().toString());

    }
}
