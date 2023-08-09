package com.openpay.marvel.model;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarvelData {

    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<Character> results;
}
