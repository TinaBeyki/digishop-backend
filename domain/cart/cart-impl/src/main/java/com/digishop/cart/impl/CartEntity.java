package com.digishop.cart.impl;

import com.digishop.product.api.ProductListDto;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document(collection = "carts")
public class CartEntity {

    @Id
    private ObjectId id;
    private ObjectId userId;
    private boolean isActive;
    private LocalDateTime modifiedOn;
    private ProductListDto products;
}
