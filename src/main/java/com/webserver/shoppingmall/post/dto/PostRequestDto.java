package com.webserver.shoppingmall.post.dto;

import com.webserver.shoppingmall.post.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostRequestDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    public PostRequestDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post toPostEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
