package com.webserver.shoppingmall.post.repository;

import com.webserver.shoppingmall.post.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
