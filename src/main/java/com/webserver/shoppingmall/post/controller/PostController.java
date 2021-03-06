package com.webserver.shoppingmall.post.controller;

import com.webserver.shoppingmall.post.dto.PostRequestDto;
import com.webserver.shoppingmall.post.model.Comment;
import com.webserver.shoppingmall.post.model.Post;
import com.webserver.shoppingmall.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public String getPosts(Pageable pageable, Model model) {
        Page<Post> posts = postService.findAll(pageable);
        model.addAttribute("posts", posts);
        return "postList";
    }

    @GetMapping("/createPost")
    public String getPostForm(Model model, PostRequestDto payload) {
        model.addAttribute("form", payload);
        return "postCreateForm";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("form") PostRequestDto payload, Principal principal) {
        postService.create(payload, principal);
        return "redirect:posts";
    }

    @GetMapping("/post/{postId}")
    public String getPost(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPostById(postId);
        List<Comment> comments = post.getComments();
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post";
    }

    @GetMapping("/post/{postId}/edit")
    public String edit(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPostById(postId);
        PostRequestDto payload = new PostRequestDto();
        payload.setId(post.getId());
        payload.setTitle(post.getTitle());
        payload.setContent(post.getContent());
        model.addAttribute("form", payload);
        return "postEditForm";
    }

    @PostMapping("/post/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId) {
        postService.delete(postId);
        return "redirect:/posts";
    }

    @PostMapping("/post/edit")
    public String editPost(@ModelAttribute("form") PostRequestDto form) {
        postService.edit(form);
        return "redirect:/posts";
    }

    @PostMapping("/post/{postId}/comment")
    public String createComment(@PathVariable("postId") Long postId, Principal principal, @RequestParam("content") String content) {
        postService.createComment(postId, principal, content);
        return "redirect:/post/{postId}";
    }
}
