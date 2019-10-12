package com.example.redditApi.service;

import com.example.redditApi.model.Post;

public class PostServiceStub implements PostService {

    @Override
    public Post createPost(Post newPost, String username) {
        Post post = new Post();
        post.setDescription("This is a post");
        return post;
    }

    @Override
    public Iterable<Post> listAllPosts() {
        return null;
    }

    @Override
    public void deletePost(Long postId){
        return;
    }
}
