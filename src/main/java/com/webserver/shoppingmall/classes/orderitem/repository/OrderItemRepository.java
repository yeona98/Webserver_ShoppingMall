package com.webserver.shoppingmall.classes.orderitem.repository;

import com.webserver.shoppingmall.classes.orderitem.model.OrderItem;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface OrderItemRepository extends JpaAttributeConverter<OrderItem, Long> {
}
