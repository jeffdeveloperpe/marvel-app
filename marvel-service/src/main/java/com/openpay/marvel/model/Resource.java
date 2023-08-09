package com.openpay.marvel.model;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {

    private int available;
    private String collectionURI;
    private List<Item> items;
    private int returned;
}
