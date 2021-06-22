package com.digishop.product.api;

public interface IProductService {

    // add product to products collection in mongo
    ProductDto srvcAddProductToProducts(ProductDto productDto);

    // input json needs only one parameter -> _id and we are searching for it
    ProductDto srvcFindProductById(ProductDto productDto);

    // update product info in products collection
    ProductDto srvcUpdateProduct(ProductDto productDto);

    ProductListDto srvcFindAllProducts();

    // find products by category : laptop, iphone , ...
    ProductListDto srvcFindAllProductsByCategory(String category);

    // brand as apple, lenovo, LG ...
    ProductListDto srvcFindAllProductsByBrand(String brand);

    // filter any products by filtered price
    ProductListDto srvcFindAllProductsFilterByPrice(ProductListDto productListDto, PriceRangeDto priceRangeDto);

}
