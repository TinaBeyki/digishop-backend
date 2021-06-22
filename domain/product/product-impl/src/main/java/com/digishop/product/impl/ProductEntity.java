package com.digishop.product.impl;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@Document(collection = "products")
public class ProductEntity {

    @Id
    private ObjectId id;
    private String name;
    private String brand;
    private String category;
    private Double price;
    private Long rate;
    private Map<String, Object> info = new HashMap<>();// is_available, quantity, image, bought, views

    private String createdDateAndTime;
}
