package com.webserver.shoppingmall.member.dto;

import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MemberRegisterRequestDto {
    private String name;
    private String email;
    private String password;
    private String city;
    private String street;
    private String zipcode;

    @Builder
    public MemberRegisterRequestDto(String name, String email, String password, String city, String street, String zipcode) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Member toMemberEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .address(new Address(city, street, zipcode))
                .build();
    }

}
