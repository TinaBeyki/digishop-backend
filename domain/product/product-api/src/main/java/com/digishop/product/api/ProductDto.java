package com.digishop.product.api;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.Map;

@Data
public class ProductDto {

    private ObjectId id;
    private String name;
    private String brand;
    private String category;
    private Double price;
    private Long rate;
    // info is dynamic base on product type
    private Map<String, Object> info = new HashMap<>();
    private String createdDateAndTime;
}
