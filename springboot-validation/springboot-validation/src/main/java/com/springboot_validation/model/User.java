package com.springboot_validation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)


    //userName Should not be null or empty
    //user name should have at least 2 charactors
    @NotEmpty
    @Size(min = 2,message = "user name should have at least 2 charactor")
    private String name;

    //email should be a valid email format
    //email should not be null or empty
    @NotEmpty
    @Email
    private String email;
    //password should not be null or empty
    //password should have at least 8 charactors
    @NotEmpty
    @Size(min = 8,message = "password should hava at least 8 charactors")
    private String password;
    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
