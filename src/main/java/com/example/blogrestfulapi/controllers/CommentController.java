package com.example.blogrestfulapi.controllers;

import com.example.blogrestfulapi.models.Blog;
import com.example.blogrestfulapi.models.Comment;
import com.example.blogrestfulapi.repositories.BlogRepository;
import com.example.blogrestfulapi.repositories.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@RestController
@RequestMapping(path = "/blog")
@NoArgsConstructor
@AllArgsConstructor
public class CommentController {

  @Autowired
  private CommentRepository repository;

  @GetMapping(path = "{blogId}/post/{postId}/comment")
  public ResponseEntity<Iterable<Comment>> list(@PathVariable Long blogId, @PathVariable Long postId) {
    return ResponseEntity.ok(repository.findByBlogIdAndPostId(blogId, postId));
  }

  @GetMapping(path = "{blogId}/post/{postId}/comment/{id}")
  public ResponseEntity<Optional<Blog>> findById(@PathVariable Long blogId, @PathVariable Long postId, @PathVariable Long id) {
    return ResponseEntity.ok(repository.findByBlogIdAndPostId(blogId, postId));
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
