package com.webserver.shoppingmall.cart.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class CartController {
    @GetMapping("carts")
    public List<Cart> aaa() {
        return Arrays.asList(new Cart(1L,"min"),new Cart(2L,"ASd"), new Cart(3L,"asdfsdfa"));
    }

    static class Cart {
        Long id;
        String name;

        public Cart() {
        }

        public Cart(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
