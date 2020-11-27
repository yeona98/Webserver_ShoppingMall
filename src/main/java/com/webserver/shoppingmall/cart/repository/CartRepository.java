package com.webserver.shoppingmall.cart.repository;

import com.webserver.shoppingmall.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
