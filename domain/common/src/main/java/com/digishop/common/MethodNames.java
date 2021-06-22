package com.digishop.common;

public class MethodNames {

    private MethodNames() {

    }

    // -------------------------------------------------- Cart ---------------------------------------------------------

    public static final String FIND_CART_BY_ID = "findCartById";
    public static final String ADD_CART_TO_CARTS = "addCartToCarts";
    public static final String UPDATE_CART = "updateCart";
    public static final String REMOVE_CART_FROM_CARTS = "removeCartFromCarts";

    // -------------------------------------------------- Order --------------------------------------------------------

    public static final String FIND_ORDER_BY_ID = "findOrderById";
    public static final String CREATE_ORDER_FROM_CART = "createOrderFromCart";
    public static final String REMOVE_ORDER_FROM_ORDERS = "removeOrderFromOrders";

    // ------------------------------------------------- Product -------------------------------------------------------

    public static final String ADD_PRODUCT_TO_PRODUCTS = "addProductToProducts";
    public static final String UPDATE_PRODUCT = "updateProduct";
    public static final String FIND_PRODUCT_BY_ID = "findProductById";
    public static final String FIND_ALL_PRODUCTS = "findAllProducts";
    public static final String FIND_ALL_PRODUCTS_FILTER_BY_CATEGORY = "findAllProductsFilterByCategory";
    public static final String FIND_ALL_PRODUCTS_FILTER_BY_BRAND = "findAllProductsFilterByBrand";
    public static final String FIND_ALL_PRODUCTS_FILTER_BY_PRICE = "findAllProductsFilterByPrice";

    // ---------------------------------------------------- User -------------------------------------------------------

    public static final String SIGN_UP = "signUp";
    public static final String SIGN_IN = "signIn";
    public static final String UPDATE_USER_PROFILE = "updateUserProfile";
    public static final String FIND_ALL_USERS = "findAllUsers";
    public static final String ADD_PRODUCT_TO_CART = "addProductToCart";
}
