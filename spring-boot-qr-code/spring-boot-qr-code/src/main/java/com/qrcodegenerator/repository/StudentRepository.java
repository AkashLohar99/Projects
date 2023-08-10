package com.qrcodegenerator.repository;

import com.qrcodegenerator.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
