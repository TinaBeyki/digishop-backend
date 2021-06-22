package com.digishop.order.api;

import com.digishop.product.api.ProductListDto;
import com.digishop.user.api.embedded_document.Address;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class OrderDto {

    private ObjectId id;
    private ObjectId userId;
    private ObjectId cartId;
    private Long total;
    private ProductListDto products;
    private Double totalPrice;
    private Address address;
    private String createdDateAndTime;
}
