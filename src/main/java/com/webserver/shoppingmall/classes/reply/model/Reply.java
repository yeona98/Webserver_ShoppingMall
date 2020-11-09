package com.webserver.shoppingmall.classes.reply.model;

import com.webserver.shoppingmall.classes.member.model.Member;
import com.webserver.shoppingmall.classes.post.model.Post;

import javax.persistence.*;

public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    private String title;
    private String contents;
    private String author;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
