package com.webserver.shoppingmall.item.service.impl;

import com.webserver.shoppingmall.item.dto.ItemRegisterRequestDto;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl  implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public Long registerItem(ItemRegisterRequestDto payload) {
        return itemRepository.save(payload.toEntity()).getId();
    }
}
