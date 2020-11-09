package com.webserver.shoppingmall.classes.cartitem.service.impl;

import com.webserver.shoppingmall.classes.cartitem.repository.CartItemRepository;
import com.webserver.shoppingmall.classes.cartitem.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
}
