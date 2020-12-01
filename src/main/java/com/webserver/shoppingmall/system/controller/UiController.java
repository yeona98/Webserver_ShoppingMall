package com.webserver.shoppingmall.system.controller;

import com.webserver.shoppingmall.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class UiController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("items")
    public String items() {
        return "items";
    }

    @GetMapping("add-item")
    public String addItem() {
        return "add-item";
    }

    @GetMapping("update-item/{id}")
    public String updateItem(@PathVariable("id") Long id) {
        return "update-item";
    }


}
