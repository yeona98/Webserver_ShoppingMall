package com.webserver.shoppingmall.cartItem.service;

import com.webserver.shoppingmall.cartItem.dto.CartItemAddDto;

public interface CartItemService {
    Long addItemToCart(final CartItemAddDto payload);
}
