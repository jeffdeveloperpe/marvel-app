package com.openpay.service.service;

import com.openpay.service.model.MarvelResponse;

public interface MarvelService {

    MarvelResponse get(Long id, int offset);
}
