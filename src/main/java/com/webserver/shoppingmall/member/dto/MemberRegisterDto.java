package com.webserver.shoppingmall.member.dto;

import com.webserver.shoppingmall.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRegisterDto {
    private String email;
    private String name;
    private String password;

    @Builder
    public MemberRegisterDto(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Member toMemberEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();
    }
}
