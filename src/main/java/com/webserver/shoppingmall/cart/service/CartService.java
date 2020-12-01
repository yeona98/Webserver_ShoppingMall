package com.webserver.shoppingmall.cart.service;

import com.webserver.shoppingmall.cart.dto.CartRegisterRequestDto;

public interface CartService {
    Long addItem(CartRegisterRequestDto payload);
}
