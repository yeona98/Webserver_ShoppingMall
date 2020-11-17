package com.webserver.shoppingmall.item.controller;

import com.webserver.shoppingmall.item.dto.ItemUploadDto;
import com.webserver.shoppingmall.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;

    @GetMapping(value = "items/upload")
    public String getItemUploadForm() {
        return "items/uploadForm";
    }
    @PostMapping("items/upload")
    public ResponseEntity<Long> uploadItem(@RequestBody final ItemUploadDto payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemService.uploadItem(payload));
    }

    @PostMapping("items/update/")
    public ResponseEntity<Long> updateItem(@RequestBody final ItemUploadDto payload) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itemService.uploadItem(payload));
    }

    @DeleteMapping("items/delete/{itemId}")
    public void deleteItem(@PathVariable("itemId") final Long itemId) {
        itemService.deleteItem(itemId);
    }
}
