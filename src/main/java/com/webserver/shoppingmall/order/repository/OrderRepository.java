package com.webserver.shoppingmall.order.repository;

import com.webserver.shoppingmall.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
