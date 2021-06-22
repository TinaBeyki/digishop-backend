package com.digishop.sku.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SkuListDto {

    private List<SkuDto> skuDtoList = new ArrayList<>();
}
