package com.webserver.shoppingmall.member.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter @Setter
public class MemberDetails extends User {

    private String email;
    private String fullName;
    private String city;
    private String street;
    private String zipcode;

    public MemberDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String fullName) {
        super(username, password, authorities);
        this.fullName = fullName;
    }
}
