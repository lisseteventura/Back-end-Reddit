package com.example.redditApi.service;

import com.example.redditApi.model.Comment;

public class CommentServiceStub implements CommentService {

    @Override
    public Comment createComment(Comment newComment, Long postId){
        Comment comment = new Comment();
        comment.setComment("This is a comment!");
        return comment;
    }
    @Override
    public Iterable<Comment> listAllComments(){
        return null;
    }

    @Override
    public void deleteComment(Long commentId){
        return;
    }
}
