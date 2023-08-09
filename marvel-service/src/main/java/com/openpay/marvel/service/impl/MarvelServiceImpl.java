package com.openpay.marvel.service.impl;

import com.openpay.marvel.model.MarvelResponse;
import com.openpay.marvel.service.MarvelService;
import com.openpay.marvel.util.HashGenerator;
import jakarta.annotation.Nullable;
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
        System.out.println(getUrl(null));
        var response = restTemplate.getForObject(getUrl(null), MarvelResponse.class);
        System.out.println(response);
    }

    public void get(Long id) {
        System.out.println(getUrl(id));
        var response = restTemplate.getForObject(getUrl(id), MarvelResponse.class);
        System.out.println(response);
    }

    private String getUrl(@Nullable Long id) {
        var endpoint = id != null ?
                ENDPOINT_CHARACTERS + '/' + id :
                ENDPOINT_CHARACTERS;

        var params = "?apikey=" + apikeyPublic +
                "&ts=" + apiTs +
                "&hash=" + getHash();

        return endpoint + params;
    }

    private String getHash() {
        return HashGenerator.generate(apiTs + apikeySecret + apikeyPublic);
    }
}
