package com.digishop.user.api.embedded_document;

import lombok.Data;

@Data
public class Address {

    private String city;
    private String state;
    private Integer district;
    private String addressInfo;
    private String zip;
}
