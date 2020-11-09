package com.webserver.shoppingmall.classes.order.repository;

import com.webserver.shoppingmall.classes.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
