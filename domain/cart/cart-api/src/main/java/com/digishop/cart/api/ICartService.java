package com.digishop.cart.api;

import org.bson.types.ObjectId;

public interface ICartService {

     CartDto srvcFindCartById(ObjectId cartId);

     CartDto srvcAddCartToCarts(CartDto cartDto);

     CartDto srvcUpdateCart(CartDto cartDto);

     Boolean srvcRemoveCartFromCarts(ObjectId cartId);


}
