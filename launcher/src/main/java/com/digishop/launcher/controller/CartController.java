package com.digishop.launcher.controller;

import com.digishop.cart.api.CartDto;
import com.digishop.cart.api.ICartService;
import com.digishop.common.MethodNames;
import com.digishop.common.ServiceNames;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/" + ServiceNames.CARTS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

    private final ICartService iCartService;

    public CartController(ICartService iCartService) {
        this.iCartService = iCartService;
    }
    //------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/" + MethodNames.FIND_CART_BY_ID)
    public CartDto findCartById(@RequestBody ObjectId objectId) {
        return iCartService.srvcFindCartById(objectId);
    }
    //------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/" + MethodNames.ADD_CART_TO_CARTS)
    public CartDto addCartToCarts(@RequestBody CartDto cartDto) {
        return iCartService.srvcAddCartToCarts(cartDto);
    }
    //------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/" + MethodNames.UPDATE_CART)
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return iCartService.srvcUpdateCart(cartDto);
    }
    //------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/" + MethodNames.REMOVE_CART_FROM_CARTS)
    public Boolean removeCartFromCarts(@RequestBody ObjectId objectId) {
        return iCartService.srvcRemoveCartFromCarts(objectId);
    }
    //------------------------------------------------------------------------------------------------------------------
}
