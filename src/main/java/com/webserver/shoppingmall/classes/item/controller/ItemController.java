package com.webserver.shoppingmall.classes.item.controller;

import com.webserver.shoppingmall.classes.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;
}
