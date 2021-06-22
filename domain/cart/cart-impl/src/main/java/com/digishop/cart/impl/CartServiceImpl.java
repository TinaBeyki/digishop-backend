package com.digishop.cart.impl;

import com.digishop.cart.api.CartDto;
import com.digishop.cart.api.ICartService;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CartServiceImpl implements ICartService {

    private final ICartRepository iCartRepository;

    public CartServiceImpl(ICartRepository iCartRepository) {
        this.iCartRepository = iCartRepository;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public CartDto srvcFindCartById(ObjectId cartId) {
        CartDto cartDto = null;
        CartEntity cartEntity = iCartRepository.findById(cartId).orElse(null);
        if (cartEntity != null) {
            cartDto = new CartDto();
            BeanUtils.copyProperties(cartEntity, cartDto);
        }
        return cartDto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    @Transactional
    public CartDto srvcAddCartToCarts(CartDto cartDto) {
        CartDto dto = null;
        CartEntity cartEntity = new CartEntity();
        BeanUtils.copyProperties(cartDto, cartEntity);
        CartEntity savedCart = iCartRepository.save(cartEntity);
        if (savedCart != null) {
            dto = new CartDto();
            BeanUtils.copyProperties(savedCart, dto);
        }
        return dto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    @Transactional
    public CartDto srvcUpdateCart(CartDto cartDto) {
        CartDto updatedCartDto = null;
        CartEntity foundCart = iCartRepository.findById(cartDto.getId()).orElse(null);
        if (foundCart != null) {
            BeanUtils.copyProperties(cartDto, foundCart);
            CartEntity updatedCart = iCartRepository.save(foundCart);
            if (updatedCart != null) {
                updatedCartDto = new CartDto();
                BeanUtils.copyProperties(updatedCart, updatedCartDto);
            }
        }
        return updatedCartDto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public Boolean srvcRemoveCartFromCarts(ObjectId cartId) {
        iCartRepository.deleteById(cartId);
        CartEntity foundCart = iCartRepository.findById(cartId).orElse(null);
        return foundCart == null;
    }
    //------------------------------------------------------------------------------------------------------------------

}
