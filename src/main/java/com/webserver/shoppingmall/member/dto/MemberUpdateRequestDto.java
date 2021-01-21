package com.webserver.shoppingmall.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberUpdateRequestDto {
    private Long id;
    private String email;
    private String name;
    private String password;
    private String city;
    private String street;
    private String zipcode;

    @Builder
    public MemberUpdateRequestDto(Long id, String email, String name, String password, String city, String street, String zipcode) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
