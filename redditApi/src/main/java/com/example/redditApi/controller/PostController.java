package com.example.redditApi.controller;

import com.example.redditApi.model.Post;
import com.example.redditApi.repository.PostRepository;
import com.example.redditApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    //used in PostControllerTest
    //We'll update the postService dependency by creating a setter method for it
    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }


    @PostMapping("/create/{username}")
    public Post createPost(@PathVariable String username, @RequestBody Post newPost) {
        return postService.createPost(newPost, username);
    }

    @GetMapping("/list")
    public Iterable<Post> listAllPosts() { return postService.listAllPosts(); }

    @DeleteMapping("/{postId}")
    public HttpStatus deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return HttpStatus.OK;
    }
}