package com.webserver.shoppingmall.cart.service.impl;

import com.webserver.shoppingmall.cart.repository.CartItemRepository;
import com.webserver.shoppingmall.cart.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
}
