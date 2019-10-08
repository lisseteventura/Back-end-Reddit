package com.example.redditApi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
//helps solve recursion issue

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    public User(){}

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    //connect user class to UserProfile
    //cascade = CascadeType.ALL - whenever we update/delete a User entity, update/delete the corresponding UserProfile
    //@JoinColumn is used to specify the foreign key column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_profile_id")
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    //connecting user table to post table
    @OneToMany(mappedBy = "user",
    cascade = CascadeType.ALL)

    private List<Post> posts;

    public List<Post> getPosts(){
        return posts;
    }

    public void setPosts(List<Post>posts){
        this.posts = posts;
    }

    //mapping users to user_role table
//    @ManyToOne(cascade = {CascadeType.DETACH,
//            CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinColumn(name = "user_role_id", nullable = false)
//    private UserRole userRole;
//
//    public UserRole getUserRole() { return userRole; }
//
//    public void setUserRole(UserRole userRole) { this.userRole = userRole; }

}
