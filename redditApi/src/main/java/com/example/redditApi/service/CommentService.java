package com.example.redditApi.service;
import com.example.redditApi.model.Comment;

public interface CommentService {

//    public Comment createComment(Comment newComment, String username);

    public Comment createComment(Comment newComment, Long postId);


    public Iterable<Comment> listAllComments();

}