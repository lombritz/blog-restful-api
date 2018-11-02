package com.example.blogrestfulapi.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "POSTS")
@Data
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BLOG_ID")
    private Blog blog;
    private String title;
    private String details;


}
