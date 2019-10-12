package com.example.redditApi.controller;

import com.example.redditApi.model.Post;
import com.example.redditApi.service.PostServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostControllerTest {
    private PostController postController;

    //dummy class implementation of PostService
    @Before
    public void initializePostController() {
        postController = new PostController();
        postController.setPostService(new PostServiceStub());
    }

    @Test
    public void createPost_SavePost_Success() {
        Post post = new Post();
        //if this description is different from the desc in PostServiceStub it will fail
        post.setDescription("This is a post");

        Post newPost = postController.createPost("travis", post);
        Assert.assertNotNull(newPost.getDescription());
        Assert.assertEquals(newPost.getDescription(), post.getDescription());
    }
}
