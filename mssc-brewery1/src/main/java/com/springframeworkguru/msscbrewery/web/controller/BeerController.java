package com.springframeworkguru.msscbrewery.web.controller;


import com.springframeworkguru.msscbrewery.web.model.BeerDto;
import com.springframeworkguru.msscbrewery.web.model.BeerDto1;
import com.springframeworkguru.msscbrewery.web.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService=beerService;
    }
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@Valid @PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

//    @GetMapping({"/{beerId1}"})
//    public ResponseEntity<BeerDto1> getBeer1(@PathVariable("beerId1") UUID beerId1) {
//        return new ResponseEntity<>(beerService.getBeerCopyById(beerId1),HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity handlePost(BeerDto beerDto, String headerValue) {
        BeerDto saveDto=beerService.saveNewBeer(beerDto);
        HttpHeaders headers=new HttpHeaders();
        headers.add("location",  "/api/v1/beer"+saveDto.getUuid().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@Valid @PathVariable("beerId") UUID beerId,BeerDto beerDto) {
        beerService.updateBeer(beerId,beerDto);
     return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) //  status :204
    public void  handleDelete(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeerById(beerId);
    }
}
