package com.webserver.shoppingmall.item.controller;

import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.payload.ItemUpdateRequestDto;
import com.webserver.shoppingmall.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@org.springframework.stereotype.Controller
public class Controller {
    private final ItemService itemService;

    @PostMapping("item")
    public String addItem(@RequestParam("name") final String name,
                          @RequestParam("price") final int price,
                          @RequestParam("stockQuantity") final int stockQuantity,
                          @RequestParam("category") Item.Category category,
                          @RequestParam("description") final String description,
                          @RequestParam("picture") final MultipartFile picture) throws IOException, NoSuchAlgorithmException {

        final Long id = itemService.addItem(name, price, stockQuantity, category, description, picture);
        return "index";
    }

}
