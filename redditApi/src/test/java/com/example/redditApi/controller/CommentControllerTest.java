package com.example.redditApi.controller;

import com.example.redditApi.model.Comment;
import com.example.redditApi.service.CommentServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommentControllerTest {


    private CommentController commentController;

    @Before
    public void initializeCommentController(){
        commentController = new CommentController();
        commentController.setCommentService(new CommentServiceStub());
    }

    @Test
    public void createComment_SaveComment_Success(){
        Comment comment = new Comment();
        comment.setComment("This is a comment!");

        Comment newComment = commentController.createComment((long)1, comment);
        Assert.assertNotNull(newComment.getComment());
        Assert.assertEquals(newComment.getComment(), comment.getComment());
    }



}
