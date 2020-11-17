package com.webserver.shoppingmall.item.service;

import com.webserver.shoppingmall.item.dto.ItemRegisterRequestDto;

public interface ItemService {
    Long registerItem(final ItemRegisterRequestDto payload);
}
