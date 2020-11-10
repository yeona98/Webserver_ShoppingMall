package com.webserver.shoppingmall.order.repository;

import com.webserver.shoppingmall.order.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
