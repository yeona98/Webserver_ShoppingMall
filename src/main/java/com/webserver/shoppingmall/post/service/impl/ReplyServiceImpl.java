package com.webserver.shoppingmall.post.service.impl;

import com.webserver.shoppingmall.post.repository.PostRepository;
import com.webserver.shoppingmall.post.repository.ReplyRepository;
import com.webserver.shoppingmall.post.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;
}
