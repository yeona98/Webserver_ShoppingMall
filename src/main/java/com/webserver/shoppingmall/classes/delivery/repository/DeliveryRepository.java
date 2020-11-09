package com.webserver.shoppingmall.classes.delivery.repository;

import com.webserver.shoppingmall.classes.delivery.model.Delivery;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface DeliveryRepository extends JpaAttributeConverter<Delivery, Long> {
}
