package com.webserver.shoppingmall.orderItem.repository;

import com.webserver.shoppingmall.orderItem.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
