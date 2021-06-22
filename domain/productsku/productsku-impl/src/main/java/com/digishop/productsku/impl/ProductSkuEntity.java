package com.digishop.productsku.impl;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "prooductSkus")
public class ProductSkuEntity {

    @Id
    private ObjectId id;
    private ObjectId productId;
    private ObjectId skuId;
}
