package com.example.redditApi.repository;

import com.example.redditApi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    //query checks to make sure username and password match
    @Query("FROM User u WHERE u.username = ?1 and u.password = ?2")
    public User login(String username, String password);

    //find user's username(method used in user service)
    public User findByUsername(String username);


}
