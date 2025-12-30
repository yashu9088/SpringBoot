package com.login.login.repository;

import com.login.login.entity.KeyPoint;
import com.login.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeyPointRepository extends JpaRepository<KeyPoint, Long> {

    List<KeyPoint> findByUser(User user);
}
