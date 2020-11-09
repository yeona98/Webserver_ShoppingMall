package com.webserver.shoppingmall.classes.cart.repository;

import com.webserver.shoppingmall.classes.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
