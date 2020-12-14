package com.webserver.shoppingmall;

import com.webserver.shoppingmall.member.dto.MemberRegisterDto;
import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.model.MemberDetails;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.member.service.MemberService;
import com.webserver.shoppingmall.post.model.Post;
import com.webserver.shoppingmall.post.model.PostForm;
import com.webserver.shoppingmall.post.repository.PostRepository;
import com.webserver.shoppingmall.post.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

@EnableJpaAuditing
@SpringBootApplication
public class ShoppingMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallApplication.class, args);
    }

    @Bean
    public String init(MemberService service, PasswordEncoder encoder) {
        service.registerMember(MemberRegisterDto.builder()
                .email("admin@admin")
                .name("운영자")
                .password(encoder.encode("admin"))
                .build());
        return "SUCCESS";
    }

    @Bean
    public CommandLineRunner initData(MemberRepository memberRepository, PostRepository postRepository) {
        return args ->
                IntStream.rangeClosed(1, 20).forEach(i -> {
                    Member member = memberRepository.save(Member.builder().name("테스트용"+i).email("1@1"+i).build());
                    PostForm postForm = new PostForm();
                    postForm.setTitle("테스트"+i);
                    postForm.setContent("test");
                    Post post = postForm.toPostEntity();
                    member.addPost(post);
                    post.addMember(member);
                    postRepository.save(post);
                });
    }
}
