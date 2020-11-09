package com.webserver.shoppingmall.classes.item.repository;

import com.webserver.shoppingmall.classes.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
