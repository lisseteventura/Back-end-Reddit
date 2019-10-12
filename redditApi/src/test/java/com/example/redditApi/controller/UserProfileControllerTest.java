package com.example.redditApi.controller;

import com.example.redditApi.model.UserProfile;
import com.example.redditApi.service.UserProfileServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserProfileControllerTest {

    private UserProfileController userProfileController;

    @Before
    public void initializeUserProfileController(){
        userProfileController = new UserProfileController();
        userProfileController.setUserProfileService(new UserProfileServiceStub());
    }
    @Test
    public void createUserProfile_SaveUserProfile_Success(){
        UserProfile userProfile = new UserProfile();
        //if the email address is different from the email that's in the UserProfileServiceStub then you'll get an error
        userProfile.setEmail("test@test.com");

        UserProfile newProfile = userProfileController.createUserProfile("batman", userProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
    }
}
