package com.example.blogrestfulapi.repositories;

import com.example.blogrestfulapi.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 11/1/2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  List<User> findByUsername(String username);
  List<User> findByEmail(String email);
}
