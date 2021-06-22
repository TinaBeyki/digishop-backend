package com.digishop.sku.impl;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "skus")
public class SkuEntity {

    @Id
    private ObjectId id;
    private ObjectId productId;
    private String skuInfo;
    private String price;
}
