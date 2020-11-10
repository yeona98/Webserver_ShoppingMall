package com.webserver.shoppingmall.item.repository;

import com.webserver.shoppingmall.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
