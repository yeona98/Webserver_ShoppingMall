package com.webserver.shoppingmall.classes.item.service.impl;

import com.webserver.shoppingmall.classes.item.repository.ItemRepository;
import com.webserver.shoppingmall.classes.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
}
