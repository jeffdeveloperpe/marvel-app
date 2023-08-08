package com.openpay.marvel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Story {

    private String resourceURI;
    private String name;
    private String type;
}
