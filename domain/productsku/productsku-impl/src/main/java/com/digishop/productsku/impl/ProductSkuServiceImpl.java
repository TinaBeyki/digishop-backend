package com.digishop.productsku.impl;

import com.digishop.productsku.api.IProductSkuService;
import org.springframework.stereotype.Service;

@Service
public class ProductSkuServiceImpl implements IProductSkuService {

    private final IProductSkuRepository iProductSkuRepository;

    public ProductSkuServiceImpl(IProductSkuRepository iProductSkuRepository) {
        this.iProductSkuRepository = iProductSkuRepository;
    }
    //------------------------------------------------------------------------------------------------------------------
}
