package com.springsecurity.SpringbootOauthauthorizationserver20.repository;

import com.springsecurity.SpringbootOauthauthorizationserver20.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository {
    User findByEmail(String email);
}
