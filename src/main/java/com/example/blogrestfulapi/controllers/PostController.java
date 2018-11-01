package com.example.blogrestfulapi.controllers;

import com.example.blogrestfulapi.models.Blog;
import com.example.blogrestfulapi.models.Post;
import com.example.blogrestfulapi.repositories.BlogRepository;
import com.example.blogrestfulapi.repositories.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@RestController
@RequestMapping(path = "/blog")
@NoArgsConstructor
@AllArgsConstructor
public class PostController {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private BlogRepository blogRepository;


  @GetMapping(path = "/{blogId}/post")
  public ResponseEntity<Iterable<Post>> list(@PathVariable Long blogId) {
    Optional<Blog> blog = blogRepository.findById(blogId);
    Iterable<Post> posts = blog.map(b -> postRepository.findByBlog(b))
            .orElse(Collections.emptyList());
    return ResponseEntity.ok(posts);
  }

//  @GetMapping(path = "/{blogId}/post/{postId}")
//  public ResponseEntity<Optional<Post>> findById(@PathVariable Long blogId,@PathVariable Long postId) {
//    return ResponseEntity.ok(postRepository.findById(blogId));
//  }
//
//  @PostMapping
//  public ResponseEntity<Blog> createBlog(@RequestBody Blog newBlog) {
//    return ResponseEntity.ok(postRepository.save(newBlog));
//  }
//
//  @PutMapping
//  public ResponseEntity<Blog> updateBlog(@RequestBody Blog updatedBlog) {
//    return ResponseEntity.ok(postRepository.save(updatedBlog));
//  }

//  @DeleteMapping(path = "{id}")
//  public ResponseEntity<Boolean> deleteBlog(@PathVariable Long id) {
//    repository.deleteById(id);
//    return ResponseEntity.ok(true);
//  }
}
