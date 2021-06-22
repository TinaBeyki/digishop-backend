package com.digishop.order.impl;

import com.digishop.cart.api.CartDto;
import com.digishop.common.DateUtil;
import com.digishop.order.api.IOrderService;
import com.digishop.order.api.OrderDto;
import com.digishop.product.api.ProductDto;
import com.digishop.product.api.ProductListDto;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository iOrderRepository;

    public OrderServiceImpl(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public OrderDto srvcFindOrderById(ObjectId objectId) {
        OrderDto orderDto = null;
        OrderEntity orderEntity = iOrderRepository.findById(objectId).orElse(null);

        if (orderEntity != null) {
            orderDto = new OrderDto();
            BeanUtils.copyProperties(orderEntity, orderDto);
        }
        return orderDto;
    }
    //------------------------------------------------------------------------------------------------------------------

    // transfer all products from cart to order
    @Override
    public OrderDto srvcCreateOrderFromCart(CartDto cartDto) {
        OrderDto orderDto = null;
        OrderDto savedOrderDto = null;
        ProductListDto productListDto = new ProductListDto();

        // ----------------- fill order ----------------
        if (cartDto.getProducts().getProductDtos() != null && !cartDto.getProducts().getProductDtos().isEmpty()) {
            List<ProductDto> products = new ArrayList<>(cartDto.getProducts().getProductDtos());
            productListDto.setProductDtos(products);
            if(!productListDto.getProductDtos().isEmpty()) {
                orderDto = new OrderDto();
                orderDto.setProducts(productListDto);

                // ------------- save order --------------
                OrderEntity orderEntity = new OrderEntity();
                BeanUtils.copyProperties(orderDto, orderEntity);
                orderEntity.setCreatedDateAndTime(DateUtil.getLocalDateAndTime());
                OrderEntity savedOrder = iOrderRepository.save(orderEntity);

                if (savedOrder != null) {
                    BeanUtils.copyProperties(savedOrder, orderDto);
                }
                return orderDto;
            }
        }
        return null;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public Boolean srvcRemoveOrderFromOrders(ObjectId orderId) {
        iOrderRepository.deleteById(orderId);
        OrderEntity foundOrder = iOrderRepository.findById(orderId).orElse(null);
        return foundOrder == null;
    }
    //------------------------------------------------------------------------------------------------------------------

   /* @Override
    public void srvcSellProducts(OrderDto orderDto) {
        orderDto.getProducts().getProductDtos().forEach(product -> {
            ProductEntity productEntity = iProductRepository.findById(product.getId()).orElse(null);

            if (productEntity != null) {
                int quantity = Integer.parseInt(productEntity.getInfo().get("quantity"));
                if (quantity > 0) {
                    quantity -= 1;
                    productEntity.getInfo().get("quantity").equals(quantity);
                    iProductRepository.save(productEntity);
                }
            }
        });
    }*/
    //------------------------------------------------------------------------------------------------------------------
}
