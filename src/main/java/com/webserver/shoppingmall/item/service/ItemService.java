package com.webserver.shoppingmall.item.service;

import com.webserver.shoppingmall.item.mapper.ItemResponseMapper;
import com.webserver.shoppingmall.item.model.Item;
import com.webserver.shoppingmall.item.payload.ItemUpdateRequestDto;
import com.webserver.shoppingmall.item.repository.ItemRepository;
import com.webserver.shoppingmall.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public Long addItem(final String name,
                        final int price,
                        final int stockQuantity,
                        final Item.Category category,
                        final String description,
                        final MultipartFile picture) throws IOException, NoSuchAlgorithmException {
        return itemRepository.save(Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .category(category)
                .description(description)
                .pictureURL(savePictureReturnURL(picture))
                .build()).getId();
    }

    @Transactional
    public List<ItemResponseMapper> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponseMapper::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updateItem(final Long id,
                           ItemUpdateRequestDto payload) throws IOException, NoSuchAlgorithmException {
        return findById(id)
                .update(payload)
                .getId();
    }

    public Item findById(final Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));
    }

    private String savePictureReturnURL(final MultipartFile files) throws IOException, NoSuchAlgorithmException {
        String origFilename = files.getOriginalFilename();
        String filename = origFilename;
        String savePath = System.getProperty("user.dir") + "/src/main/resources/static/images";
        System.out.println(savePath);
        if (!new File(savePath).exists()) {
            try{
                new File(savePath).mkdir();
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }
        String filePath = savePath + "/" + filename;
        files.transferTo(new File(filePath));

        return filePath;
    }
}
