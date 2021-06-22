package com.digishop.launcher.controller;

import com.digishop.cart.api.CartDto;
import com.digishop.common.MethodNames;
import com.digishop.common.ServiceNames;
import com.digishop.order.api.IOrderService;
import com.digishop.order.api.OrderDto;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/" + ServiceNames.ORDERS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    private final IOrderService iOrderService;

    public OrderController(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.CREATE_ORDER_FROM_CART)
    public OrderDto createOrderFromCart(@RequestBody CartDto cartDto) {
        return iOrderService.srvcCreateOrderFromCart(cartDto);
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.FIND_ORDER_BY_ID)
    public OrderDto findOrderById(@RequestBody ObjectId objectId) {
        return iOrderService.srvcFindOrderById(objectId);
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.REMOVE_ORDER_FROM_ORDERS)
    public Boolean removeOrderFromOrders(@RequestBody ObjectId objectId) {
        return iOrderService.srvcRemoveOrderFromOrders(objectId);
    }
    //------------------------------------------------------------------------------------------------------------------
}
