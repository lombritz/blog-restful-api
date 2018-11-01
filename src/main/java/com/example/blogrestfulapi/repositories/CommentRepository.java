package com.example.blogrestfulapi.repositories;

import com.example.blogrestfulapi.models.Blog;
import com.example.blogrestfulapi.models.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@Repository
public interface CommentRepository extends CrudRepository<Blog, Long> {
  List<Blog> findBySubjectLike(String subject);
  @Query("select comments from Comment comments where comments.post.blog.id = ?1 and comments.post.id = ?2")
  List<Comment> findByBlogIdAndPostId(Long blogId, Long postId);
}
