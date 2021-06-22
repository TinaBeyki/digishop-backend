package com.digishop.cart.api;

import com.digishop.product.api.ProductListDto;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class CartDto {

    private ObjectId id;
    private boolean isActive;
    private LocalDateTime modifiedOn;
    private ProductListDto products;
}
