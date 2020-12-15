package com.webserver.shoppingmall.post.service.impl;

import com.webserver.shoppingmall.member.model.Member;
import com.webserver.shoppingmall.member.repository.MemberRepository;
import com.webserver.shoppingmall.post.model.Comment;
import com.webserver.shoppingmall.post.model.Post;
import com.webserver.shoppingmall.post.model.PostForm;
import com.webserver.shoppingmall.post.repository.CommentRepository;
import com.webserver.shoppingmall.post.repository.PostRepository;
import com.webserver.shoppingmall.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

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
    public Page<Post> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        return postRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Long createComment(Long postId, Principal principal, String content) {
        Post post = postRepository.getPostById(postId);
        Member member = memberRepository.findMemberByEmail(principal.getName());
        Comment comment = Comment.builder()
                .comment(content)
                .member(member)
                .post(post)
                .build();
        commentRepository.save(comment);
        return comment.getId();
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
