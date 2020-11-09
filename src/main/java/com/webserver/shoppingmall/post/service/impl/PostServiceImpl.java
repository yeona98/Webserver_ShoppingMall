package com.webserver.shoppingmall.post.service.impl;

import com.webserver.shoppingmall.post.repository.PostRepository;
import com.webserver.shoppingmall.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
}
