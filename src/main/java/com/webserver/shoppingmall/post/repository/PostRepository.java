package com.webserver.shoppingmall.post.repository;

import com.webserver.shoppingmall.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
