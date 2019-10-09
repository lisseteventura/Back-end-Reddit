package com.example.redditApi.service;

import com.example.redditApi.config.JwtUtil;
import com.example.redditApi.model.User;
import com.example.redditApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;
    //load User information using username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        if(user==null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, new ArrayList<>());
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

//        authorities.add(new SimpleGrantedAuthority(user.getUserRole().getName()));

        return authorities;
    }


    @Autowired
    UserRepository userRepository;


    //get list of all users
    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    //allows user to sign
//    @Override
//    public User createUser(User newUser){
//        return userRepository.save(newUser);
//    }
    //When a User signs up we get a newly generated token as a response
    @Override
    public String createUser(User newUser) {
        newUser.setUsername(newUser.getUsername());
        newUser.setPassword(newUser.getPassword());
        if(userRepository.save(newUser) != null){
            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }


    @Override
    public User login(String username, String password){
        return userRepository.login(username, password);
    }

    @Autowired
    JwtUtil jwtUtil;

    //login request generates web token for us only if the User's username and password match
    @Override
    public String login(User user){
        if(userRepository.login(user.getUsername(), user.getPassword()) != null){
            UserDetails userDetails = loadUserByUsername(user.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    //get user's username(to create user's profile)
    @Override
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }



}
