package com.webserver.shoppingmall.post.service;

import com.webserver.shoppingmall.post.dto.PostRequestDto;
import com.webserver.shoppingmall.post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;

public interface PostService {

    void create(PostRequestDto payload, Principal principal);

    void edit(PostRequestDto payload);

    Long delete(Long id);

    Page<Post> findAll(Pageable pageable);

    Long createComment(Long postId, Principal principal, String content);

    List<Post> getAllPosts();

    Post getPostById(Long id);

}
