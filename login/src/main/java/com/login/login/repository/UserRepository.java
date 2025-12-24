package com.login.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.login.login.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
