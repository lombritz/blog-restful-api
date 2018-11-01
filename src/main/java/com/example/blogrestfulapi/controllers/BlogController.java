package com.example.blogrestfulapi.controllers;

import com.example.blogrestfulapi.models.Blog;
import com.example.blogrestfulapi.repositories.BlogRepository;
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
@RequestMapping(path = "/blog")
@NoArgsConstructor
@AllArgsConstructor
public class BlogController {

  @Autowired
  private BlogRepository repository;

  @GetMapping
  public ResponseEntity<Iterable<Blog>> list() {
    return ResponseEntity.ok(repository.findAll());
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<Optional<Blog>> findById(@PathVariable Long id) {
    return ResponseEntity.ok(repository.findById(id));
  }

  @PostMapping
  public ResponseEntity<Blog> createBlog(@RequestBody Blog newBlog) {
    return ResponseEntity.ok(repository.save(newBlog));
  }

  @PutMapping
  public ResponseEntity<Blog> updateBlog(@RequestBody Blog updatedBlog) {
    return ResponseEntity.ok(repository.save(updatedBlog));
  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity<Boolean> deleteBlog(@PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok(true);
  }
}
