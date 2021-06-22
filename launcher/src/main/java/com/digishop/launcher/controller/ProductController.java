package com.digishop.launcher.controller;

import com.digishop.common.MethodNames;
import com.digishop.common.ServiceNames;
import com.digishop.launcher.InputStringDto;
import com.digishop.product.api.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/" + ServiceNames.PRODUCTS)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
            this.iProductService = iProductService;
    }

    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.ADD_PRODUCT_TO_PRODUCTS)
    public ProductDto addProductToCollection(@RequestBody ProductDto productDto) {
        return iProductService.srvcAddProductToProducts(productDto);
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.FIND_PRODUCT_BY_ID)
    public ProductDto findProductById(@RequestBody ProductDto productDto) {
        return iProductService.srvcFindProductById(productDto);
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.FIND_ALL_PRODUCTS_FILTER_BY_BRAND)
    public ProductListDto findAllProductsFilterByBrand(@RequestBody InputStringDto inputStringDto) {
        return iProductService.srvcFindAllProductsByBrand(inputStringDto.getInputString());
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.FIND_ALL_PRODUCTS_FILTER_BY_CATEGORY)
    public ProductListDto findAllProductsFilterByCategory(@RequestBody InputStringDto inputStringDto) {
        return iProductService.srvcFindAllProductsByCategory(inputStringDto.getInputString());
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.FIND_ALL_PRODUCTS_FILTER_BY_PRICE)
    public ProductListDto findAllProductsFilterByPrice(@RequestBody ProductListDto productListDto,
                                                       @RequestBody PriceRangeDto priceRangeDto) {
        return iProductService.srvcFindAllProductsFilterByPrice(productListDto, priceRangeDto);
    }
    //------------------------------------------------------------------------------------------------------------------

    @PostMapping(path = "/" + MethodNames.FIND_ALL_PRODUCTS)
    public ProductListDto findAllProducts() {

        return iProductService.srvcFindAllProducts();
    }
    //------------------------------------------------------------------------------------------------------------------
}
