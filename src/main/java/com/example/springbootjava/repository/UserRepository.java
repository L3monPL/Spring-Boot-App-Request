package com.example.springbootjava.repository;

import com.example.springbootjava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
