package com.webserver.shoppingmall.classes.post.model;

import com.webserver.shoppingmall.classes.member.model.Member;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String contents;
    private String author;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Post(String title, String contents, String author, Member member) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.member = member;
    }
}
