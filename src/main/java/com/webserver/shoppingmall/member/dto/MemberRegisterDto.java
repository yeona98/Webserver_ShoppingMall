package com.webserver.shoppingmall.member.dto;

import com.webserver.shoppingmall.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class MemberRegisterDto {
    //@NotEmpty(message = "이메일은 필수 입니다.")
    private String email;
    private String name;
    private String password;
    private String city;
    private String street;
    private String zipcode;

    @Builder
    public MemberRegisterDto(String email, String name, String password, String city, String street, String zipcode) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Member toMemberEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .city(city)
                .street(street)
                .zipcode(zipcode)
                .build();
    }
}
