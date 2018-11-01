package com.example.blogrestfulapi.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@Entity
@Table(name = "USERS")
@Data
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String username;
  private String email;

  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthDate;

  @OneToMany(mappedBy = "author")
  private List<Blog> blogs;
}
