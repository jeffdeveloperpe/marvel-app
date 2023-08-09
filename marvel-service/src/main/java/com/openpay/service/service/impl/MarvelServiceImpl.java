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
    private static final String ENDPOINT_EVENTS = URL_BASE + "/v1/public/events";
    private static final String ENDPOINT_STORIES = URL_BASE + "/v1/public/stories";
    private static final String ENDPOINT_SERIES = URL_BASE + "/v1/public/series";
    private static final String ENDPOINT_COMICS = URL_BASE + "/v1/public/comics";

    @Value("${marvel.apikey.public}")
    private String apikeyPublic;

    @Value("${marvel.apikey.secret}")
    private String apikeySecret;

    @Value("${marvel.ts}")
    private String apiTs;

    private final RestTemplate restTemplate;

    @Override
    public MarvelResponse get(@Nullable Long id, int offset) {
        var response = restTemplate.getForObject(getUrl(id, offset, ENDPOINT_CHARACTERS), MarvelResponse.class);
        System.out.println(response);

        return response;
    }

    @Override
    public MarvelResponse getEvent(Long id) {
        var response = restTemplate.getForObject(getUrl(id, 0, ENDPOINT_EVENTS), MarvelResponse.class);
        System.out.println(response);

        return response;
    }

    @Override
    public MarvelResponse getStory(Long id) {
        var response = restTemplate.getForObject(getUrl(id, 0, ENDPOINT_STORIES), MarvelResponse.class);
        System.out.println(response);

        return response;
    }

    @Override
    public MarvelResponse getSerie(Long id) {
        var response = restTemplate.getForObject(getUrl(id, 0, ENDPOINT_SERIES), MarvelResponse.class);
        System.out.println(response);

        return response;
    }

    @Override
    public MarvelResponse getComic(Long id) {
        var response = restTemplate.getForObject(getUrl(id, 0, ENDPOINT_COMICS), MarvelResponse.class);
        System.out.println(response);

        return response;
    }

    private String getUrl(@Nullable Long id, int offset, String baseEndpoint) {
        var endpoint = id != null ?
                baseEndpoint + "/" + id + "?apikey=" + apikeyPublic :
                baseEndpoint + "?apikey=" + apikeyPublic + "&offset=" + offset;

        var params = "&ts=" + apiTs +
                "&hash=" + getHash();

        return endpoint + params;
    }

    private String getHash() {
        return HashGenerator.generate(apiTs + apikeySecret + apikeyPublic);
    }
}
