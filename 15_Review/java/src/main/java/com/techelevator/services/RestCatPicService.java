package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

    private static final String API_URL_PIC = "https://random-cat-api.netlify.app/.netlify/functions/api";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public CatPic getPic() {
            // Auto-generated method stub
            CatPic catPic = restTemplate.getForObject(API_URL_PIC, CatPic.class);
            return catPic;
        }
    }

