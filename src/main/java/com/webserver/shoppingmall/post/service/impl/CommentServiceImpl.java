package com.webserver.shoppingmall.post.service.impl;

import com.webserver.shoppingmall.post.repository.PostRepository;
import com.webserver.shoppingmall.post.repository.CommentRepository;
import com.webserver.shoppingmall.post.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository replyRepository;
    private final PostRepository postRepository;
}
