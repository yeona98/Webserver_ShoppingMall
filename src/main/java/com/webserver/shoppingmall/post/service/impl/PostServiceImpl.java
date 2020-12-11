package com.webserver.shoppingmall.post.service.impl;

import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.post.model.Post;
import com.webserver.shoppingmall.post.model.PostForm;
import com.webserver.shoppingmall.post.repository.PostRepository;
import com.webserver.shoppingmall.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void create(PostForm postForm, Principal principal) {
        Post post = postForm.toPostEntity();
        Member member = memberRepository.findMemberByEmail(principal.getName());
        member.addPost(post);
        post.addMember(member);
        postRepository.save(post);
    }

    @Override
    @Transactional
    public void edit(PostForm postForm) {
        Post post = postRepository.getPostById(postForm.getId());
        post.editPost(postForm.getTitle(), postForm.getContent());
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        postRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.getPostById(id);
    }
}
