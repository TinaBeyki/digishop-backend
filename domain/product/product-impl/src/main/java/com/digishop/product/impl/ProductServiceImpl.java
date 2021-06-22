package com.digishop.product.impl;

import com.digishop.common.DateUtil;
import com.digishop.product.api.IProductService;
import com.digishop.product.api.PriceRangeDto;
import com.digishop.product.api.ProductDto;
import com.digishop.product.api.ProductListDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository iProductRepository;

    public ProductServiceImpl(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    @Transactional
    public ProductDto srvcAddProductToProducts(ProductDto productDto) {
        ProductDto dto = null;
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productDto, productEntity);
        productEntity.setCreatedDateAndTime(DateUtil.getLocalDateAndTime());
        ProductEntity savedProduct = iProductRepository.save(productEntity);

        if (savedProduct != null) {
            dto = new ProductDto();
            BeanUtils.copyProperties(savedProduct, dto);
        }
        return dto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    @Transactional
    public ProductDto srvcUpdateProduct(ProductDto productDto) {
        ProductDto updatedProductDto = null;

        // when we find object and then trying to save(), it will be updated
        ProductEntity productFoundById = iProductRepository.findById(productDto.getId()).orElse(null);
        if (productFoundById != null) {
            BeanUtils.copyProperties(productDto, productFoundById);
            ProductEntity updatedProductEntity = iProductRepository.save(productFoundById);

            if (updatedProductEntity != null) {
                updatedProductDto = new ProductDto();
                BeanUtils.copyProperties(updatedProductEntity, updatedProductDto);
            }
        }
        return updatedProductDto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public ProductDto srvcFindProductById(ProductDto productDto) {
        ProductDto dto = null;
        ProductEntity productFoundById = iProductRepository.findById(productDto.getId()).orElse(null);
        if (productFoundById != null) {
            dto = new ProductDto();
            BeanUtils.copyProperties(productFoundById, productDto);
        }
        return dto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public ProductListDto srvcFindAllProducts() {
        ProductListDto productListDto = new ProductListDto();
        List<ProductDto> productDtos = new ArrayList<>();

        List<ProductEntity> allProducts = iProductRepository.findAll();
        if (allProducts != null && !allProducts.isEmpty()) {

            allProducts.forEach(product -> {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                productDtos.add(productDto);
            });
            productListDto.setProductDtos(productDtos);
        }
        return productListDto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public ProductListDto srvcFindAllProductsByCategory(String category) {
        ProductListDto productListDto = new ProductListDto();
        List<ProductDto> productDtos = new ArrayList<>();

        List<ProductEntity> allProductsByCategory = iProductRepository.findAllByCategory(category);
        if (allProductsByCategory != null && !allProductsByCategory.isEmpty()) {

            allProductsByCategory.forEach(product -> {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                productDtos.add(productDto);
            });
            productListDto.setProductDtos(productDtos);
        }
        return productListDto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public ProductListDto srvcFindAllProductsByBrand(String brand) {
        ProductListDto productListDto = new ProductListDto();
        List<ProductDto> productDtos = new ArrayList<>();

        List<ProductEntity> allProductsByCategory = iProductRepository.findAllByCategory(brand);
        if (allProductsByCategory != null && !allProductsByCategory.isEmpty()) {

            allProductsByCategory.forEach(product -> {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                productDtos.add(productDto);
            });
            productListDto.setProductDtos(productDtos);
        }
        return productListDto;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public ProductListDto srvcFindAllProductsFilterByPrice(ProductListDto productListDto, PriceRangeDto priceRangeDto) {
        ProductListDto productsListDto = new ProductListDto();

        List<ProductDto> productsFilteredByPrice = productListDto.getProductDtos()
                .stream()
                .filter(productDto -> productDto.getPrice() > priceRangeDto.getMinimumPrice() &&
                        productDto.getPrice() < priceRangeDto.getMaximumPrice())
                .collect(Collectors.toList());

        if (productsFilteredByPrice != null && !productsFilteredByPrice.isEmpty()) {
            productsListDto.setProductDtos(productsFilteredByPrice);
        }
        return productsListDto;
    }
    //------------------------------------------------------------------------------------------------------------------

}
