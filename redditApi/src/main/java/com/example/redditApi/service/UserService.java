package com.example.redditApi.service;

import com.example.redditApi.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

//import UserDetailsService so that Spring Security talks to our database
public interface UserService extends UserDetailsService {

    public Iterable<User> listUsers();

    //user sign up
    //updated method so that we automatically get token once user signs up
    public String createUser(User newUser);

    //user login
    public User login(String username, String password);

    //get user's username(function later used in UserProfile)
    public User getUser(String username);

    //method used to generate token once user logs in
    public String login(User user);




}
