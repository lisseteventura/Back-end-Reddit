package com.example.redditApi.controller;
import com.example.redditApi.model.Comment;
import com.example.redditApi.model.Post;
import com.example.redditApi.service.CommentService;
import com.example.redditApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    //create comments with post id
    @PostMapping("/create/{postId}")
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment newComment) {
        return commentService.createComment(newComment, postId);
    }
    @GetMapping("/list")
    public Iterable<Comment> listAllComments() {
        return commentService.listAllComments();
    }

    //delete comment by comment id
    @DeleteMapping("/{commentId}")
    public HttpStatus deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return HttpStatus.OK;
    }
}
