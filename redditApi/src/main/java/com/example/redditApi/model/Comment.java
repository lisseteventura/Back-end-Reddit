package com.example.redditApi.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String comment;

    public Comment(){}

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){ this.comment = comment;
    }
    //connecting to comments to  posts
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "post_id")

    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Post post;

    @JsonIgnore
    public Post getPost(){
        return post;
    }
    public void setPost(Post post){
        this.post = post;
    }
}