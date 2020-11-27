package com.webserver.shoppingmall.cartItem.repository;

import com.webserver.shoppingmall.cartItem.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
