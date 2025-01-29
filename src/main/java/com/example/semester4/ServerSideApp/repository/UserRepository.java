package com.example.semester4.ServerSideApp.repository;

import com.example.semester4.ServerSideApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
