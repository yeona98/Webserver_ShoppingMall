package com.webserver.shoppingmall.cart.repository;

import com.webserver.shoppingmall.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
