package com.webserver.shoppingmall.order.repository;

import com.webserver.shoppingmall.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
