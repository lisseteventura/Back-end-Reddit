package com.example.redditApi.service;


import com.example.redditApi.model.Post;
import com.example.redditApi.model.User;
import com.example.redditApi.repository.PostRepository;
import com.example.redditApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    //allows user to create post
    @Override
    public Post createPost(Post newPost, String username){
        User user = userRepository.findByUsername(username);
        newPost.setUser(user);
        return postRepository.save(newPost);
    }

    //list all posts
    @Override
    public Iterable<Post> listAllPosts(){
        return postRepository.findAll();
    }

    //delete post by post id
    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);

    }


}
