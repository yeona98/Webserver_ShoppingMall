package com.webserver.shoppingmall.classes.cart.service.impl;

import com.webserver.shoppingmall.classes.cart.repository.CartRepository;
import com.webserver.shoppingmall.classes.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
}
