package com.webserver.shoppingmall.member.model;

import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.order.model.Orders;
import com.webserver.shoppingmall.post.model.Comment;
import com.webserver.shoppingmall.post.model.Post;
import com.webserver.shoppingmall.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String name;
    private String password;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Post> posts = new ArrayList<>();

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Cart cart;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();


    @Builder
    public Member(String email, String name, String password, String city, String street, String zipcode) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // LOGIC
    public void update(String name, String email, String password, String city, String street, String zipcode) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
    public void addCart(Cart cart) {
        this.cart = cart;
    }
}
