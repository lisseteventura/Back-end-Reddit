package com.example.redditApi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

//helps solve recursion issue
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column
    private String description;

    public Post(){}

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    //connecting post table to user table
    @ManyToOne(cascade = {CascadeType.DETACH,
    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "users_id")
    private User user;

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
}
