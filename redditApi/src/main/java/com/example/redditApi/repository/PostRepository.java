package com.example.redditApi.repository;

import com.example.redditApi.model.Post;
import com.example.redditApi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
//    @Query("from Post up inner join User u on u.User.id = ?1 and up.id = u.Post.id")
    //void deleteById(Long postId);
//    @Query("{'id': ?0}")
//    public Post findPostById(Long id);
//
//    @Query(" {'user' : ?0}")
//    public List<Post> findPostByUser(User user);
    public Iterable<Post> findAllById(String anyString);


}
