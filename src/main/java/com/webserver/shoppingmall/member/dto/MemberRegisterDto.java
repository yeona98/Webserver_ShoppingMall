package com.webserver.shoppingmall.member.dto;

import com.webserver.shoppingmall.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@NoArgsConstructor
public class MemberRegisterDto {
    @NotEmpty(message = "이메일은 필수 입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    @NotEmpty(message = "이름을 입력해 주세요.")
    private String name;
    @NotEmpty(message = "비밀번호를 입력해 주세요.")
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
