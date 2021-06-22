package com.digishop.productsku.api;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class ProductSkuDto {

    private ObjectId id;
    private ObjectId productId;
    private ObjectId skuId;
}
