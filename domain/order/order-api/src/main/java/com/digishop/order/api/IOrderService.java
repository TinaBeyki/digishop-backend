package com.digishop.order.api;

import com.digishop.cart.api.CartDto;
import org.bson.types.ObjectId;

public interface IOrderService {

    OrderDto srvcFindOrderById(ObjectId objectId);

    OrderDto srvcCreateOrderFromCart(CartDto cartDto);

    Boolean srvcRemoveOrderFromOrders(ObjectId orderId);

    //void srvcSellProducts(OrderDto productDto);
}
