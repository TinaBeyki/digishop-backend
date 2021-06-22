package com.digishop.productsku.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductSkuListDto {

    private List<ProductSkuDto> productSkuDtoList = new ArrayList<>();

}
