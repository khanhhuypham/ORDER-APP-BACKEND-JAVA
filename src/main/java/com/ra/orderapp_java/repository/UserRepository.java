package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsUserByEmail(String email);
    User getUserByUsername(String username);
}