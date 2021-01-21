package com.webserver.shoppingmall.post.repository;

import com.webserver.shoppingmall.post.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
