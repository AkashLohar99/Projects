package com.springboot_validation.controller;

import com.springboot_validation.model.User;
import com.springboot_validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User saveUser=userService.createUser(user);
        return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
    }
}
