package com.EmployeeManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee_info")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private long cno;
    private  String email;

    public Employee(long id, String firstName, String lastName, long cno, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cno = cno;
        this.email = email;
    }

    public Employee() {
    }
}
