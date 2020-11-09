package com.webserver.shoppingmall.post.controller;

import com.webserver.shoppingmall.post.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;
}
