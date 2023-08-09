package com.openpay.service.model;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String resourceURI;
    private String name;
    private String type;
}
