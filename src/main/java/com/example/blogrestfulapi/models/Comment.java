package com.example.blogrestfulapi.models;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@Entity
@Table(name = "COMMENTS")
@Data
public class Comment {
  @Id
  @GeneratedValue
  private Long id;
  private String comment;

  @ManyToOne
  @JoinColumn(name = "AUTHOR_ID")
  private User author;

  @ManyToOne
  @JoinColumn(name = "POST_ID")
  private Post post;
}
