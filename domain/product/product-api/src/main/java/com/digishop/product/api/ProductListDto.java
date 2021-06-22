package com.digishop.product.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductListDto {

    private List<ProductDto> productDtos = new ArrayList<>();
}
