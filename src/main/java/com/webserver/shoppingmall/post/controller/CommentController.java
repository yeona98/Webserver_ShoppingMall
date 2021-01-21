package com.webserver.shoppingmall.post.controller;

import com.webserver.shoppingmall.post.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService replyService;
}
