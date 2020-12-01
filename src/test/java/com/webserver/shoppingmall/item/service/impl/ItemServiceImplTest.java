package com.webserver.shoppingmall.item.service.impl;

import com.webserver.shoppingmall.ShoppingMallApplicationTests;
import com.webserver.shoppingmall.item.model.Category;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceImplTest extends ShoppingMallApplicationTests {
    @Autowired
    ItemRepository itemRepository;

    @AfterEach
    void deleteAll() {
        itemRepository.deleteAll();
        System.out.println("아이템 다삭제됨");
    }

    @Test
    void 아이템등록() {
        //when
        String name = "aaa";
        int price = 10000;
        int stockQuantity = 5;
        String pictureURL = "??";


        //when
        Item item = Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .category(Category.BAGS)
                .pictureURL(pictureURL)
                .build();

        Item result = itemRepository.save(item);

        //then
        assertNotNull(result);
        assertEquals(name, result.getName());
        assertEquals(price, result.getPrice());
    }
}