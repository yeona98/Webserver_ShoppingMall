package com.webserver.shoppingmall.item.service;

import com.webserver.shoppingmall.item.dto.ItemUpdateDto;
import com.webserver.shoppingmall.item.dto.ItemUploadDto;

public interface ItemService {
    Long uploadItem(final ItemUploadDto payload);
    //Long updateItem(final ItemUpdateDto payload);
    void deleteItem(final Long itemId);
}
