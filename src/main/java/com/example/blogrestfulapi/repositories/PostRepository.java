package com.example.blogrestfulapi.repositories;

import com.example.blogrestfulapi.models.Blog;
import com.example.blogrestfulapi.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
  List<Post> findByBlog(Blog blog);
}
