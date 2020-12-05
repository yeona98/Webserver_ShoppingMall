package com.webserver.shoppingmall.member.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {
    private Long id;
    private String email;
    private String name;
    private String password;
    private String city;
    private String street;
    private String zipcode;
}
