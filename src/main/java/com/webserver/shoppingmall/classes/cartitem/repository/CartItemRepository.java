package com.webserver.shoppingmall.classes.cartitem.repository;

import com.webserver.shoppingmall.classes.cartitem.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
