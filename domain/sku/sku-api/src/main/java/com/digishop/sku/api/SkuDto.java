package com.digishop.sku.api;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class SkuDto {

    private ObjectId id;
    private ObjectId productId;
    private String skuInfo;
    private String price;
}
