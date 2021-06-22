package com.digishop.inventory.api;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class InventoryDto {

    private ObjectId id;
    private ObjectId skuId;
    private Long quantity;
}
