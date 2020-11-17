package com.webserver.shoppingmall.cartItem;

public interface CartItemService {
    Long addItemToCart(final CartItemAddDto payload);
}
