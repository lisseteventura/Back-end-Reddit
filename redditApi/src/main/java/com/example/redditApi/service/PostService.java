package com.example.redditApi.service;

import com.example.redditApi.model.Post;

public interface PostService {

    //allows users to create post
    public Post createPost(Post newPost, String username);
    //list all posts
    public Iterable<Post> listAllPosts();

}
