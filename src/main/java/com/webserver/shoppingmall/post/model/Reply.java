package com.webserver.shoppingmall.post.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
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

    @Builder
    public Reply(Long id, String title, String contents, String author, Post post) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.post = post;
    }
}
