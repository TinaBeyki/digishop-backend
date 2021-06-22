package com.digishop.inventory.impl;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "")
public class InventoryEntity {

    @Id
    private ObjectId id;
    private ObjectId skuId;
    private Long quantity;
}
