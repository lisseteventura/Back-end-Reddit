package com.example.redditApi.service;
import com.example.redditApi.model.Comment;

public interface CommentService {


    //create comment on post using postId
    public Comment createComment(Comment newComment, Long postId);

    //list all comments
    public Iterable<Comment> listAllComments();

    //delete comment by commentId
    public void deleteComment(Long commentId);

}