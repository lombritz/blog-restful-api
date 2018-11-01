package com.example.blogrestfulapi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
  // TODO: insert POSTS here!!! :)
}
