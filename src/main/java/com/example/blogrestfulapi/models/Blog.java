package com.example.blogrestfulapi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

  // TODO: insert POSTS here!!! :)
}
