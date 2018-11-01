package com.example.blogrestfulapi.controllers;

import com.example.blogrestfulapi.models.Blog;
import com.example.blogrestfulapi.models.Like;
import com.example.blogrestfulapi.repositories.BlogRepository;
import com.example.blogrestfulapi.repositories.LikeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
public class LikeController {

    @Autowired
    private LikeRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Like>> list() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Optional<Like>>findById(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Like> createBlog(@RequestBody Like newLike) {
        return ResponseEntity.ok(repository.save(newLike));
    }

    @PutMapping
    public ResponseEntity<Like> updateBlog(@RequestBody Like updatedLike) {
        return ResponseEntity.ok(repository.save(updatedLike));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Boolean> deleteBlog(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok(true);
    }
}
