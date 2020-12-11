package com.webserver.shoppingmall.post.controller;

import com.webserver.shoppingmall.post.model.Post;
import com.webserver.shoppingmall.post.model.PostForm;
import com.webserver.shoppingmall.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "postList";
    }

    @GetMapping("/createPost")
    public String getPostForm(Model model, PostForm form) {
        model.addAttribute("form", form);
        return "postCreateForm";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("form") PostForm form, Principal principal) {
        postService.create(form, principal);
        return "redirect:posts";
    }

    @GetMapping("/post/{postId}")
    public String getPost(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/post/{postId}/edit")
    public String edit(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPostById(postId);
        PostForm form = new PostForm();
        form.setId(post.getId());
        form.setTitle(post.getTitle());
        form.setContent(post.getContent());
        model.addAttribute("form", form);
        return "postEditForm";
    }

    @PostMapping("/post/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId) {
        postService.delete(postId);
        return "redirect:/posts";
    }

    @PostMapping("/post/edit")
    public String editPost(@ModelAttribute("form") PostForm form) {
        postService.edit(form);
        return "redirect:/posts";
    }
}
