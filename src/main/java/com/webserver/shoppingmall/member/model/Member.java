package com.webserver.shoppingmall.member.model;

import com.webserver.shoppingmall.cart.model.Cart;
import com.webserver.shoppingmall.order.model.Order;
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

//    @Embedded
//    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Post> posts = new ArrayList<>();

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Cart cart;

    @Builder
    public Member(String email, String name, String password, String city, String street, String zipcode) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    //== 로직 ==//

    public void update(String email, String name, String password, String city, String street, String zipcode) {
        this.email = email;
        this.name = name;
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
