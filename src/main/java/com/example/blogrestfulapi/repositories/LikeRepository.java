package com.example.blogrestfulapi.repositories;

import com.example.blogrestfulapi.models.Blog;
import com.example.blogrestfulapi.models.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Long> {

}
