package com.digishop.order.impl;

import com.digishop.product.api.ProductListDto;
import com.digishop.user.api.embedded_document.Address;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class OrderEntity {

    @Id
    private ObjectId id;
    private ObjectId userId;
    private ObjectId cartId;
    private Long total;
    private ProductListDto products;
    private Double totalPrice;
    private Address address;
    private String createdDateAndTime;
}
