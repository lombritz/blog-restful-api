package com.example.blogrestfulapi.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@Entity
@Table(name = "BLOGS")
@Data
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String subject;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

//    @OneToMany(mappedBy = "blog")
//    private List<Post> posts;
}
