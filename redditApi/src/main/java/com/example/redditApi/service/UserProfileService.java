package com.example.redditApi.service;

import com.example.redditApi.model.UserProfile;

public interface UserProfileService {

    //add a user's profile if username is given
    public UserProfile createUserProfile(String username, UserProfile newProfile);

    //get user's profile information if username is given.
    public UserProfile getUserProfile(String username);
}
