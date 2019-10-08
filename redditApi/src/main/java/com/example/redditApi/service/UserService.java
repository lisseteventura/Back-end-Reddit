package com.example.redditApi.service;

import com.example.redditApi.model.User;

public interface UserService {

    public Iterable<User> listUsers();

    //user sign up
    public User createUser(User newUser);

    //user login
    public User login(String username, String password);

    //get user's username(function later used in UserProfile)
    public User getUser(String username);



}
