package com.example.redditApi.controller;

import com.example.redditApi.model.Post;
import com.example.redditApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/create/{username}")
    public Post createPost(@PathVariable String username, @RequestBody Post newPost) {
        return postService.createPost(newPost, username);
    }

    @GetMapping("/list")
    public Iterable<Post> listAllPosts() {
        return postService.listAllPosts();
    }
}
