package com.openpay.marvel.service.impl;

import com.openpay.marvel.service.MarvelService;
import com.openpay.marvel.util.HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarvelServiceImpl implements MarvelService {

    private static final String URL_BASE = "https://gateway.marvel.com";
    private static final String ENDPOINT_CHARACTERS = URL_BASE + "/v1/public/characters";

    @Value("${marvel.apikey.public}")
    private String apikeyPublic;

    @Value("${marvel.apikey.secret}")
    private String apikeySecret;

    @Value("${marvel.ts}")
    private String apiTs;

    @Autowired private RestTemplate restTemplate;

    public void list() {
        System.out.println(getUrl());
        Object response = restTemplate.getForObject(getUrl(), Object.class);
        System.out.println(response);
    }

    private String getUrl() {
        return ENDPOINT_CHARACTERS +
                "?apikey=" + apikeyPublic +
                "&ts=" + apiTs +
                "&hash=" + getHash();
    }

    private String getHash() {
        return HashGenerator.generate(apiTs + apikeySecret + apikeyPublic);
    }
}
