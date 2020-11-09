package com.webserver.shoppingmall.order.repository;

import com.webserver.shoppingmall.order.model.Delivery;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface DeliveryRepository extends JpaAttributeConverter<Delivery, Long> {
}
