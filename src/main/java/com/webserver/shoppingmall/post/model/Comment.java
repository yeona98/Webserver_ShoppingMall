package com.webserver.shoppingmall.post.model;

import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment(Long id, String comment, Member member, Post post) {
        this.id = id;
        this.comment = comment;
        this.member = member;
        this.post = post;
    }

    public Comment addComment(Post post) {
        post.getComments().add(this);
        return this;
    }
}
