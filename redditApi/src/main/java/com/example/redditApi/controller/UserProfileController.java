package com.example.redditApi.controller;

import com.example.redditApi.model.UserProfile;
import com.example.redditApi.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;


    //endpoint for creating a user profile if username is given
    @PostMapping("/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile userProfile){
        return userProfileService.createUserProfile(username, userProfile);
    }

    //endpoint for getting the user's profile if username is given
    @GetMapping("/{username}")
    public UserProfile getUserProfile(@PathVariable String username){
        return userProfileService.getUserProfile(username);
    }

    //we're changing our dependency injection method from field injection to setter injection
    @Autowired
    public void setUserProfileService(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }
}
