package com.techelevator.services;

import com.techelevator.model.CatCard;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

    private static final String API_URL_FACT = "https://cat-fact.herokuapp.com/facts/random";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public CatFact getFact() {
        // Auto-generated method stub
        CatFact catFact = restTemplate.getForObject(API_URL_FACT, CatFact.class);
        return catFact;
    }

}
