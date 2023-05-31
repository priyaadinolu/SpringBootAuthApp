package com.example.authApp.repository;

import com.example.authApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findAllByEmail(String name);
    User findAllById(Integer id);

    List<User> findAll();
}
