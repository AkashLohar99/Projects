package com.numetry.in;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name" ,nullable = false )
    private String firstName;
    @Column(name = "last_name" ,nullable = false )
    private String lastName;
    @Column(name = "email")
    private String email;

}
