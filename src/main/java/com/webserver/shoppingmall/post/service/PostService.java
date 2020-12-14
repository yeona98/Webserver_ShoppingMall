package com.webserver.shoppingmall.post.service;

import com.webserver.shoppingmall.post.model.Post;
import com.webserver.shoppingmall.post.model.PostForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;

public interface PostService {
    void create(PostForm postForm, Principal principal);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    void edit(PostForm postForm);
    Long delete(Long id);
    Page<Post> findAll(Pageable pageable);
    Long createComment(Long postId, Principal principal);
}
