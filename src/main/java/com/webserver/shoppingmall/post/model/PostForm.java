package com.webserver.shoppingmall.post.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {
    private Long id;
    private String title;
    private String content;

    public Post toPostEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
