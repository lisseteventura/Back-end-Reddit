package com.example.redditApi.service;
import com.example.redditApi.model.Comment;
import com.example.redditApi.model.Post;
import com.example.redditApi.model.User;
import com.example.redditApi.repository.CommentRepository;
import com.example.redditApi.repository.PostRepository;
import com.example.redditApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserService userService;
    @Autowired
    PostRepository postRepository;

    //create comment with post id
    @Override
    public Comment createComment(Comment newComment, Long postId) {
        Post post = postRepository.findById(postId).get();
        newComment.setPost(post);
        return commentRepository.save(newComment);
    }

    public Iterable<Comment> listAllComments() {
        return commentRepository.findAll();
    }

    //delete comment by comment id
    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}