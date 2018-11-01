package com.example.blogrestfulapi.controllers;

import com.example.blogrestfulapi.models.Blog;
import com.example.blogrestfulapi.models.User;
import com.example.blogrestfulapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
  @Autowired
  private UserRepository repository;

  @GetMapping
  public ResponseEntity<Iterable<User>> list() {
    return ResponseEntity.ok(repository.findAll());
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
    return ResponseEntity.ok(repository.findById(id));
  }

  @PostMapping
  public ResponseEntity<User> createBlog(@RequestBody User newUser) {
    return ResponseEntity.ok(repository.save(newUser));
  }

  @PutMapping
  public ResponseEntity<User> updateBlog(@RequestBody User updatedUser) {
    return ResponseEntity.ok(repository.save(updatedUser));
  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity<Boolean> deleteBlog(@PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(true);
  }
}
