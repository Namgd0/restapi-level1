package com.example.restfulapidemo.repository;

import com.example.restfulapidemo.dto.EmployeeDto;
import com.example.restfulapidemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByFirstname(String firstname);
}
