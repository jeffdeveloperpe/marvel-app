package com.openpay.service.service;

import com.openpay.service.model.MarvelResponse;

public interface MarvelService {

    MarvelResponse get(Long id, int offset);
    MarvelResponse getEvent(Long id);
    MarvelResponse getStory(Long id);
    MarvelResponse getSerie(Long id);
    MarvelResponse getComic(Long id);
}
