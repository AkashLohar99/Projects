package com.numetry.in;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployee(){
        Employee employee=Employee.builder()
                .firstName("Akash").lastName("Lohar").email("akashlohar4165@gmail.com"). build();
        employeeRepository.save(employee);
        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void getEmployeeTest(){
        Employee employee=employeeRepository.findById(1L).get();
        Assertions.assertThat(employee.getId()).isEqualTo(1L);
    }
    @Test
    @Order(3)
    public void getListOfEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        Assertions.assertThat(employees.size()).isGreaterThan(0);

    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest(){
        Employee employee= employeeRepository.findById(1L).get();
        employee.setEmail("akash@gmail.com");
        Employee employeeUpdated =  employeeRepository.save(employee);
        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("akash@gmail.com");
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){
        Employee employee = employeeRepository.findById(1L).get();
        employeeRepository.delete(employee);
        //employeeRepository.deleteById(1L);

        Employee employee1=null;
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail("akash@gmail.com");
        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();

    }
}