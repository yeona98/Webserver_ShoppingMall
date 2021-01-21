package com.webserver.shoppingmall.member.dto;

import com.webserver.shoppingmall.member.model.Address;
import com.webserver.shoppingmall.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@NoArgsConstructor
public class MemberRegisterRequestDto {

    @NotEmpty(message = "이름을 입력해 주세요.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해 주세요.")
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
                .city(city)
                .street(street)
                .zipcode(zipcode)
                .build();
    }
}
