package com.openpay.service.service.impl;

import com.openpay.service.service.MarvelService;
import com.openpay.service.model.MarvelResponse;
import com.openpay.service.util.HashGenerator;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MarvelServiceImpl implements MarvelService {

    private static final String URL_BASE = "https://gateway.marvel.com";
    private static final String ENDPOINT_CHARACTERS = URL_BASE + "/v1/public/characters";

    @Value("${marvel.apikey.public}")
    private String apikeyPublic;

    @Value("${marvel.apikey.secret}")
    private String apikeySecret;

    @Value("${marvel.ts}")
    private String apiTs;

    private final RestTemplate restTemplate;

    @Override
    public MarvelResponse get(@Nullable Long id) {
        var response = restTemplate.getForObject(getUrl(id), MarvelResponse.class);
        System.out.println(response);

        return response;
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
