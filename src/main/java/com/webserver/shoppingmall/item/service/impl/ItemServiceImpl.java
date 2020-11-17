package com.webserver.shoppingmall.item.service.impl;

import com.webserver.shoppingmall.item.dto.ItemUpdateDto;
import com.webserver.shoppingmall.item.dto.ItemUploadDto;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public Long uploadItem(ItemUploadDto payload) {
        return itemRepository.save(payload.toItemEntity()).getId();
    }

//    @Override
//    @Transactional
//    public Long updateItem(ItemUpdateDto payload) {
//
//
//    }

    @Override
    @Transactional
    public void deleteItem(final Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
