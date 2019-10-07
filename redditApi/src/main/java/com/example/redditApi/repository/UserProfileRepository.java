package com.example.redditApi.repository;

import com.example.redditApi.model.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

    //left join between User and UserProfile
    //gets information from left table(user) and matches it with the userProfile id
    @Query("from UserProfile up left join User u on u.username = ?1 and up.id = u.userProfile.id")
    public UserProfile findProfileByUsername(String username);
}
