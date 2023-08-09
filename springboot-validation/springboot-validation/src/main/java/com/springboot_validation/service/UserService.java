package com.springboot_validation.service;

import com.springboot_validation.model.User;
import com.springboot_validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user)
    {
        return userRepository.save(user);
    }

}
