package com.example.blogrestfulapi.repositories;

import com.example.blogrestfulapi.models.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {
  List<Blog> findBySubjectLike(String subject);
}
