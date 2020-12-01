package com.webserver.shoppingmall.item.controller;

import com.webserver.shoppingmall.item.mapper.ItemResponseMapper;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;

    @GetMapping("api/items")
    public List<ItemResponseMapper> getItems() {
        return itemService.getItems();
    }

    @GetMapping("item/{id}")
    public String itemDetail(@PathVariable final Long id) {
        return itemService.findById(id).toString();
    }


}
