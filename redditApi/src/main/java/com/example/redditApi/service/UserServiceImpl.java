package com.example.redditApi.service;

import com.example.redditApi.model.User;
import com.example.redditApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    //get list of all users
    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    //allows user to sign
    @Override
    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    @Override
    public User login(String username, String password){
        return userRepository.login(username, password);
    }

    //get user's username(to create user's profile)
    @Override
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }



}
