package com.digishop.cart.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartListDto {

    private List<CartDto> cartDtoList = new ArrayList<>();
}
